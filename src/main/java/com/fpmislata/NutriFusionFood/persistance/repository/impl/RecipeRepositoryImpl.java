package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import com.fpmislata.NutriFusionFood.common.container.*;
import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.IngredientMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.RecipeMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.ToolMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecipeRepositoryImpl implements RecipeRepository {
    private RecipeDao recipeDao;
    private IngredientDao ingredientDao;
    private ToolDao toolDao;

    public RecipeRepositoryImpl(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
        this.toolDao = ToolIoC.getToolDao();
        this.ingredientDao = IngredientIoC.getIngredientDao();
    }

    private Recipe addParametersMapper(RecipeEntity recipeEntity){
        int id = recipeEntity.getId();
        Recipe recipe = RecipeMapper.toRecipe(recipeEntity);

        // Añadir listado ingredientes
        List<Ingredient> ingredientList = IngredientMapper.toIngredientList(ingredientDao.findByRecipe(id));
        recipe.setIngredientList(ingredientList);

        // Añadir listado herramientas
        List<Tool> toolList = ToolMapper.toToolList(toolDao.findByRecipe(id));
        recipe.setToolList(toolList);

        // Editar los alergenos
        Map<String, Boolean> allergens = recipe.getAllergen();
        for (Ingredient ingredient : recipe.getIngredientList()) {
            if (ingredient.isGluten()) {
                allergens.put("gluten", true);
            }
            if (ingredient.isLactose()) {
                allergens.put("lactose", true);
            }
        }
        recipe.setAllergen(allergens);
        return recipe;
    }

    @Override
    public List<Recipe> findAllRecipe() {
        List<RecipeEntity> recipeEntityList = recipeDao.findAllRecipe();
        List<Recipe> recipeList = new ArrayList<>();
        for (RecipeEntity recipeEntity : recipeEntityList) {
            recipeList.add(addParametersMapper(recipeEntity));
        }
        return recipeList;
    }

    @Override
    public Recipe findByIdRecipe(Integer id) {
        RecipeEntity recipeEntity = recipeDao.findByIdRecipe(id);
        if (recipeEntity == null) {
            return null;
        }
        return addParametersMapper(recipeEntity);
    }

    @Override
    public void delete(Integer id) {
        recipeDao.delete(id);
    }

    public void insert(Recipe recipe) {
        recipeDao.insert(RecipeMapper.toRecipeEntity(recipe),
                IngredientMapper.toIngredientEntityList(recipe.getIngredientList()),
                ToolMapper.toToolEntityList(recipe.getToolList()));
    }

    @Override
    public void update(Recipe recipe) {
        recipeDao.update(RecipeMapper.toRecipeEntity(recipe),
                IngredientMapper.toIngredientEntityList(recipe.getIngredientList()),
                ToolMapper.toToolEntityList(recipe.getToolList()));
    }

    @Override
    public List<Recipe> findByCategory(Integer categoryId) {
        List<RecipeEntity> recipeEntityCategory = recipeDao.findByCategory(categoryId);
        List<Recipe> recipeCategory = new ArrayList<>();
        for (RecipeEntity recipeEntity : recipeEntityCategory) {
            recipeCategory.add(addParametersMapper(recipeEntity));
        }
        return recipeCategory;
    }

    @Override
    public List<Recipe> findByNutritionist(Integer nutritionistId) {
        List<RecipeEntity> recipeEntityNutritionist = recipeDao.findByNutritionist(nutritionistId);
        List<Recipe> recipeNutritionist = new ArrayList<>();
        for (RecipeEntity recipeEntity : recipeEntityNutritionist) {
            recipeNutritionist.add(addParametersMapper(recipeEntity));
        }
        return recipeNutritionist;
    }

    @Override
    public Recipe findByNameAndNutritionist(String name, int userId) {
        return RecipeMapper.toRecipe(recipeDao.findByNameAndNutritionist(name, userId));
    }

    @Override
    public List<Recipe> findByNoLactose() {
        List<Recipe> recipeList = findAllRecipe();
        List<Recipe> noLactoseRecipeList = new ArrayList<>();
        for (Recipe recipe:recipeList){
            if (!recipe.getAllergen().get("lactose")){
                noLactoseRecipeList.add(recipe);
            }
        }
        return noLactoseRecipeList;
    }

    @Override
    public List<Recipe> findByNoGluten() {
        List<Recipe> recipeList = findAllRecipe();
        List<Recipe> noGlutenRecipeList = new ArrayList<>();
        for (Recipe recipe:recipeList){
            if (!recipe.getAllergen().get("gluten")){
                noGlutenRecipeList.add(recipe);
            }
        }
        return noGlutenRecipeList;
    }

    @Override
    public List<Recipe> findByTime(Integer timeMin, Integer timeMax) {
        List<RecipeEntity> recipeEntityList = recipeDao.findByTime(timeMin,timeMax);
        List<Recipe> recipeList = new ArrayList<>();
        for (RecipeEntity recipeEntity : recipeEntityList) {
            recipeList.add(addParametersMapper(recipeEntity));
        }
        return recipeList;
    }
    @Override
    public List<Integer> findMaxMinTime(){
        return recipeDao.findMaxMinTime();
    }

    @Override
    public void addFavorites(Recipe recipe, Integer userId) {
        recipeDao.addFavorites(RecipeMapper.toRecipeEntity(recipe),userId);
    }

    @Override
    public void removeFavorites(Recipe recipe, Integer userId) {
        recipeDao.removeFavorites(RecipeMapper.toRecipeEntity(recipe),userId);
    }

    @Override
    public List<Recipe> findFavoritesByUser(Integer userId) {
        return RecipeMapper.toRecipeList(recipeDao.findFavoritesByUser(userId));
    }
}
