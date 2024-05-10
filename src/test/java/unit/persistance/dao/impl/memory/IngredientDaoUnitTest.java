package unit.persistance.dao.impl.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import antiguo.memory.IngredientDaoMemory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IngredientDaoUnitTest {
    IngredientDao ingredientDao = new IngredientDaoMemory();
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @DisplayName("Find all the ingredients in the database")
    @Test
    public void testFindAllIngredients() {
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList ;
        if (lang.equals("es")){
            expectedIngredientList= new ArrayList<>(Arrays.asList(
                    new IngredientEntity(1,true,false,"pan",10,12, new TypeEntity()),
                    new IngredientEntity(2,false,false,"pollo",10,12, new TypeEntity()),
                    new IngredientEntity(3,false,false,"tomate",10,12, new TypeEntity()),
                    new IngredientEntity(4,false,false,"puerro",10,12, new TypeEntity()),
                    new IngredientEntity(5,false,true,"helado",10,12, new TypeEntity())
            ));
        } else if (lang.equals("en")) {
            expectedIngredientList= new ArrayList<>(Arrays.asList(
                    new IngredientEntity(1,true,false,"bread",10,12, new TypeEntity()),
                    new IngredientEntity(2,false,false,"chicken",10,12, new TypeEntity()),
                    new IngredientEntity(3,false,false,"tomato",10,12, new TypeEntity()),
                    new IngredientEntity(4,false,false,"leek",10,12, new TypeEntity()),
                    new IngredientEntity(5,false,true,"ice cream",10,12, new TypeEntity())
            ));
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
            expectedIngredient = new IngredientEntity(1,true,false,"pan",10,12, new TypeEntity());
        } else if (lang.equals("en")) {
            expectedIngredient = new IngredientEntity(1,true,false,"bread",10,12, new TypeEntity());
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
        if (lang.equals("es")){

        }
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(Arrays.asList(new IngredientEntity(3,false,false,"tomate",10,12, new TypeEntity())));
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
        ingredientDao.insert(new IngredientEntity(6,false,true,"queso",10,12, new TypeEntity()));
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"pan",10,12, new TypeEntity()),
            new IngredientEntity(2,false,false,"pollo",10,12, new TypeEntity()),
            new IngredientEntity(3,false,false,"tomate",10,12, new TypeEntity()),
            new IngredientEntity(4,false,false,"puerro",10,12, new TypeEntity()),
            new IngredientEntity(5,false,true,"helado",10,12, new TypeEntity()),
            new IngredientEntity(6,false,true,"queso",10,12, new TypeEntity())
        ));
        assertEquals(expectedIngredientList, actualIngredientList);
    }

    @DisplayName("Delete ingredients from the database")
    @Test
    public void testDeleteIngredients() {
        ingredientDao.delete(5);
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"pan",10,12, new TypeEntity()),
            new IngredientEntity(2,false,false,"pollo",10,12, new TypeEntity()),
            new IngredientEntity(3,false,false,"tomate",10,12, new TypeEntity()),
            new IngredientEntity(4,false,false,"puerro",10,12, new TypeEntity())
        ));
        assertEquals(expectedIngredientList, actualIngredientList);
    }
}
