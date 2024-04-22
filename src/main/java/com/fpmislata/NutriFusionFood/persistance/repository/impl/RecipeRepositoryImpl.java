package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import com.fpmislata.NutriFusionFood.common.container.UserIoC;
import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.CategoryDaoImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.IngredientDaoImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.ToolDaoImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.TypeDaoImpl;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.CategoryMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.IngredientMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.RecipeMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.ToolMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.UserMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.TypeMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecipeRepositoryImpl implements RecipeRepository {
    private RecipeDao recipeDao;
    private UserDao userDao;
    private CategoryDao categoryDao;
    private IngredientDao ingredientDao;
    private ToolDao toolDao;
    private TypeDao typeDao;

    public RecipeRepositoryImpl(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
        this.userDao = UserIoC.getUserDao();
        this.categoryDao = new CategoryDaoImpl();
        this.toolDao = new ToolDaoImpl();
        this.ingredientDao = new IngredientDaoImpl();
        this.typeDao = new TypeDaoImpl();
    }


    @Override
    public List<Recipe> findAllRecipe() {
        List<RecipeEntity> recipeEntityList = recipeDao.findAllRecipe();
        List<Recipe> recipeList = new ArrayList<>();
        for(RecipeEntity recipeEntity:recipeEntityList){
            recipeList.add(findByIdRecipe(recipeEntity.getId()));
        }
        return recipeList;
    }

    @Override
    public Recipe findByIdRecipe(Integer id) {
        RecipeEntity recipeEntity = recipeDao.findByIdRecipe(id);
        Recipe recipe = RecipeMapper.toRecipe(recipeEntity);

        //Añadir usuario
        int idUser = recipeEntity.getUserId();
        User user = UserMapper.toUser(userDao.findByIdNutritionist(idUser));
        recipe.setUser(user);

        //Añadir categoria
        int idCategory = recipeEntity.getCategoryId();
        Category category = CategoryMapper.toCategory(categoryDao.findByIdCategory(idCategory));
        recipe.setCategory(category);

        //Añadir listado ingredientes, cambiar a map para poder añadir cantidades?
        List<IngredientEntity> ingredientEntityList = ingredientDao.findByRecipe(id);
        List<Ingredient> ingredientList = new ArrayList<>();
        for(IngredientEntity ingredientEntity : ingredientEntityList){
            Type type = TypeMapper.toType(typeDao.findByIdType(ingredientEntity.getTypeId()));
            Ingredient ingredient = IngredientMapper.toIngredient(ingredientEntity);
            ingredient.setType(type);
            ingredientList.add(ingredient);
        }
        recipe.setIngredientList(ingredientList);
        
        //Añadir listado herramientas
        List<Tool> toolList = ToolMapper.toToolList(toolDao.findByRecipe(id));
        recipe.setToolList(toolList);
        
        //Editar los alergenos
        //Da error
        Map<String,Boolean> allergens = recipe.getAllergen();
        for(Ingredient ingredient : recipe.getIngredientList()){
            if (ingredient.isGluten()) {
                allergens.put("gluten",true);
            }
            if (ingredient.isLactose()) {
                allergens.put("lactose",true);
            }
        }
        recipe.setAllergen(allergens);

        return recipe;
    }

    @Override
    public void delete(Integer id) {
        recipeDao.delete(id);
    }

    public void insert(Recipe recipe) {
        recipeDao.insert(RecipeMapper.toRecipeEntity(recipe));
    }

    @Override
    public List<Recipe> findByCategory(Integer categoryId) {
        List<RecipeEntity> recipeEntityCategory = recipeDao.findByCategory(categoryId);
        List<Recipe> recipeCategory = new ArrayList<>();
        for(RecipeEntity recipeEntity:recipeEntityCategory){
            recipeCategory.add(findByIdRecipe(recipeEntity.getId()));
        }
        return recipeCategory;
    }

    @Override
    public List<Recipe> findByNutritionist(Integer nutritionistId) {
        List<RecipeEntity> recipeEntityNutritionist = recipeDao.findByNutritionist(nutritionistId);
        List<Recipe> recipeNutritionist = new ArrayList<>();
        for(RecipeEntity recipeEntity:recipeEntityNutritionist){
            recipeNutritionist.add(findByIdRecipe(recipeEntity.getId()));
        }
        return recipeNutritionist;
    }
}
