package unit.persistance.dao.impl.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import data.IngredientData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.IngredientDaoMemory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IngredientDaoUnitTest {

    IngredientDao ingredientDao;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");
    @BeforeEach
    public void setUpAll(){
        ingredientDao = new IngredientDaoMemory();
    }
    @DisplayName("Find all the ingredients in the database")
    @Test
    public void testFindAllIngredients() {
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList ;
        if (lang.equals("es")){
            expectedIngredientList= IngredientData.ingredientEntityList_es;
        } else if (lang.equals("en")) {
            expectedIngredientList= IngredientData.ingredientEntityList_en;
        }else {
            expectedIngredientList=new ArrayList<>();
        }
        assertEquals(expectedIngredientList, actualIngredientList);
    }

    @DisplayName("Find ingredients by their ids")
    @Test
    public void testFindIngredientsById() {
        IngredientEntity actualIngredient = ingredientDao.findByIdIngredient(1);
        IngredientEntity expectedIngredient;
        if (lang.equals("es")){
            expectedIngredient = IngredientData.ingredientEntityList_es.get(0);
        } else if (lang.equals("en")) {
            expectedIngredient = IngredientData.ingredientEntityList_en.get(0);
        }else{
            expectedIngredient=null;
        }
        assertEquals(expectedIngredient, actualIngredient);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null for negative,zero or wrong id")
    public void returnNullWrongIngredientId(int id){
        IngredientEntity ingredientEntity = ingredientDao.findByIdIngredient(id);
        assertNull(ingredientEntity);
    }

    @DisplayName("Find the ingredients by their recipes")
    @Test
    public void testFindIngredientsByRecipe() {
        List<IngredientEntity> actualIngredientList = ingredientDao.findByRecipe(2);
        List<IngredientEntity> expectedIngredientList;
        if (lang.equals("es")){
            expectedIngredientList = new ArrayList<>(Arrays.asList(
                    IngredientData.ingredientEntityList_es.get(2)));
        } else if (lang.equals("en")) {
            expectedIngredientList = new ArrayList<>(Arrays.asList(
                    IngredientData.ingredientEntityList_en.get(2)));
        }else {
            expectedIngredientList = new ArrayList<>();
        }
        assertEquals(expectedIngredientList, actualIngredientList);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null for negative,zero or wrong id")
    public void returnNullWrongRecipeId(int id){
        List<IngredientEntity> actualIngredientList = ingredientDao.findByRecipe(id);
        List<IngredientEntity> expectedIngredientList = new ArrayList<>();
        assertEquals(expectedIngredientList,actualIngredientList);
    }

    @DisplayName("Insert new ingredients into the database")
    @Test
    public void testInsertNewIngredients() {
        IngredientEntity newIngredient;
        List<IngredientEntity> expectedIngredientList;
        if (lang.equals("es")){
            expectedIngredientList = new ArrayList<>(IngredientData.ingredientEntityList_es);
            newIngredient = new IngredientEntity(6,false,true,"queso",10,12, new TypeEntity(3,"lacteo"));
        } else if (lang.equals("en")) {
            expectedIngredientList = new ArrayList<>(IngredientData.ingredientEntityList_en);
            newIngredient = new IngredientEntity(6,false,true,"cheese",10,12, new TypeEntity(3,"dairy"));
        } else {
            expectedIngredientList = new ArrayList<>();
            newIngredient = null;
        }
        ingredientDao.insert(newIngredient);
        expectedIngredientList.add(newIngredient);
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        assertEquals(expectedIngredientList, actualIngredientList);

    }

    @DisplayName("Delete ingredients from the database")
    @Test
    public void testDeleteIngredients() {
        ingredientDao.delete(5);
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList;
        if (lang.equals("es")){
            expectedIngredientList = new ArrayList<>(IngredientData.ingredientEntityList_es);
        } else if (lang.equals("en")) {
            expectedIngredientList = new ArrayList<>(IngredientData.ingredientEntityList_en);
        }else{
            expectedIngredientList = new ArrayList<>();
        }
        expectedIngredientList.remove(4);
        assertEquals(expectedIngredientList, actualIngredientList);
    }
}
