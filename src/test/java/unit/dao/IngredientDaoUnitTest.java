package unit.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.RecipeDaoMemory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.ComposedDao;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.ComposedDaoMemory;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.IngredientDaoMemory;

public class IngredientDaoUnitTest {
    IngredientDao ingredientDao = new IngredientDaoMemory();
    RecipeDao recipeDao = new RecipeDaoMemory();

    @DisplayName("Find all the ingredients in the database")
    @Test
    public void testFindAllIngredients() {
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"pan","bread",10,12, 6),
            new IngredientEntity(2,false,false,"pollo","chicken",10,12, 1),
            new IngredientEntity(3,false,false,"tomate","tomato",10,12, 5),
            new IngredientEntity(4,false,false,"puerro","leek",10,12, 4),
            new IngredientEntity(5,false,true,"helado","ice cream",10,12, 3)
        ));
        assertEquals(expectedIngredientList, actualIngredientList);
    }

    @DisplayName("Find ingredients by their ids")
    @Test
    public void testFindIngredientsById() {
        IngredientEntity actualIngredient = ingredientDao.findByIdIngredient(1);
        IngredientEntity expectedIngredient = new IngredientEntity(1,true,false,"pan","bread",10,12, 6);
        assertEquals(expectedIngredient, actualIngredient);
    }
    @Test
    @DisplayName("Return null for ingredient id negative")
    public void notAcceptIngredientIdNegative(){
        IngredientEntity actualIngredient = ingredientDao.findByIdIngredient(-3);
        assertNull(actualIngredient);
    }
    @Test
    @DisplayName("Return null for ingredient id not in the list")
    public void notAcceptIngredientIdNotInList(){
        int i = ingredientDao.findAllIngredient().size();
        IngredientEntity actualIngredient = ingredientDao.findByIdIngredient(i+1);
        assertNull(actualIngredient);
    }

    @DisplayName("Find the ingredients by their recipes")
    @Test
    public void testFindIngredientsByRecipe() {
        List<IngredientEntity> actualIngredientList = ingredientDao.findByRecipe(2);
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(Arrays.asList(new IngredientEntity(3,false,false,"tomate","tomato",10,12, 5)));
        assertEquals(expectedIngredientList, actualIngredientList);
    }
    @Test
    @DisplayName("Return null for recipe id negative")
    public void notAcceptRecipeIdNegative(){
        List<IngredientEntity> actualIngredientList = ingredientDao.findByRecipe(-3);
        List<IngredientEntity> expectedIngredientList = new ArrayList<>();
        assertEquals(expectedIngredientList,actualIngredientList);
    }
    @Test
    @DisplayName("Return null for recipe id not in the list")
    public void notAcceptRecipeIdNotInList(){
        int i = recipeDao.findAllRecipe().size();
        List<IngredientEntity> actualIngredientList = ingredientDao.findByRecipe(i+1);
        List<IngredientEntity> expectedIngredientList = new ArrayList<>();
        assertEquals(expectedIngredientList,actualIngredientList);
    }

    @DisplayName("Insert new ingredients into the database")
    @Test
    public void testInsertNewIngredients() {
        ingredientDao.insert(new IngredientEntity(6,false,true,"queso","cheese",10,12, 2));
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"pan","bread",10,12, 6),
            new IngredientEntity(2,false,false,"pollo","chicken",10,12, 1),
            new IngredientEntity(3,false,false,"tomate","tomato",10,12, 5),
            new IngredientEntity(4,false,false,"puerro","leek",10,12, 4),
            new IngredientEntity(5,false,true,"helado","ice cream",10,12, 3),
            new IngredientEntity(6,false,true,"queso","cheese",10,12, 2)
        ));
        assertEquals(expectedIngredientList, actualIngredientList);
    }

    @DisplayName("Delete ingredients from the database")
    @Test
    public void testDeleteIngredients() {
        ingredientDao.delete(5);
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"pan","bread",10,12, 6),
            new IngredientEntity(2,false,false,"pollo","chicken",10,12, 1),
            new IngredientEntity(3,false,false,"tomate","tomato",10,12, 5),
            new IngredientEntity(4,false,false,"puerro","leek",10,12, 4)
        ));
        assertEquals(expectedIngredientList, actualIngredientList);
    }
}
