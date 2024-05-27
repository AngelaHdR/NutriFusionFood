package data;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeData {
    public static final List<RecipeEntity> recipeEntityList = new ArrayList<>(Arrays.asList(
            new RecipeEntity(1,"Tortilla patata","es", "x","Paso 1...", 30,
                    new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true,"p1","mail1","jose"),
                    new CategoryEntity(1,"salado")),
            new RecipeEntity(2,"Salmorejo","es","x", "Paso 1...", 60,
                    new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true,"p1","mail1","jose"),
                    new CategoryEntity(1,"salado")),
            new RecipeEntity(3,"Ramen", "es","x","Paso 1...", 240,
                    new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"p3","mail3","pepe"),
                    new CategoryEntity(1,"salado")),
            new RecipeEntity(4,"Torrijas", "es","x","Paso 1...", 45,
                    new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"p3","mail3","pepe"),
                    new CategoryEntity(2,"postre")),
            new RecipeEntity(5,"Smoothie", "es","x","Paso 1...", 15,
                    new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"p3","mail3","pepe"),
                    new CategoryEntity(3,"bebida"))
    ));
    public static final List<Recipe> recipeList = new ArrayList<>(Arrays.asList(
            new Recipe(1,"Tortilla patata","es", "x","Paso 1...", 30,
                    new User(1,"Jose","Perez","Garcia","1989-08-18", true,"p1","mail1","jose"),
                    new Category(1,"salado")),
            new Recipe(2,"Salmorejo","es","x", "Paso 1...", 60,
                    new User(1,"Jose","Perez","Garcia","1989-08-18", true,"p1","mail1","jose"),
                    new Category(1,"salado")),
            new Recipe(3,"Ramen", "es","x","Paso 1...", 240,
                    new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"p3","mail3","pepe"),
                    new Category(1,"salado")),
            new Recipe(4,"Torrijas", "es","x","Paso 1...", 45,
                    new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"p3","mail3","pepe"),
                    new Category(2,"postre")),
            new Recipe(5,"Smoothie", "es","x","Paso 1...", 15,
                    new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"p3","mail3","pepe"),
                    new Category(3,"bebida"))
    ));

    public static List<Recipe> findRecipeList(){
        return recipeList;
    }


    public static List<RecipeEntity> findRecipeEntityList(){
        return recipeEntityList;
    }
}
