package data;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IngredientData {
    public static final List<IngredientEntity> ingredientEntityList_es = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"pan",10,12, new TypeEntity(6,"hidrados")),
            new IngredientEntity(2,false,false,"pollo",10,12, new TypeEntity(1,"carne")),
            new IngredientEntity(3,false,false,"tomate",10,12, new TypeEntity(5,"fruta")),
            new IngredientEntity(4,false,false,"puerro",10,12, new TypeEntity(4,"verdura")),
            new IngredientEntity(5,false,true,"helado",10,12, new TypeEntity(3,"lacteo"))
    ));
    public static final List<IngredientEntity> ingredientEntityList_en = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"bread",10,12, new TypeEntity(6,"carbs")),
            new IngredientEntity(2,false,false,"chicken",10,12, new TypeEntity(1,"meat")),
            new IngredientEntity(3,false,false,"tomato",10,12, new TypeEntity(5,"fruit")),
            new IngredientEntity(4,false,false,"leek",10,12, new TypeEntity(4,"vegetable")),
            new IngredientEntity(5,false,true,"ice cream",10,12, new TypeEntity(3,"dairy"))
    ));
    public static final List<Ingredient> ingredientList_es = new ArrayList<>(Arrays.asList(
            new Ingredient(1,true,false,"pan",10,12, new Type(6,"hidrados")),
            new Ingredient(2,false,false,"pollo",10,12, new Type(1,"carne")),
            new Ingredient(3,false,false,"tomate",10,12, new Type(5,"fruta")),
            new Ingredient(4,false,false,"puerro",10,12, new Type(4,"verdura")),
            new Ingredient(5,false,true,"helado",10,12, new Type(3,"lacteo"))
    ));

    public static final List<Ingredient> ingredientList_en = new ArrayList<>(Arrays.asList(
            new Ingredient(1,true,false,"bread",10,12, new Type(6,"carbs")),
            new Ingredient(2,false,false,"chicken",10,12, new Type(1,"meat")),
            new Ingredient(3,false,false,"tomato",10,12, new Type(5,"fruit")),
            new Ingredient(4,false,false,"leek",10,12, new Type(4,"vegetable")),
            new Ingredient(5,false,true,"ice cream",10,12, new Type(3,"dairy"))
    ));
    public static List<Ingredient> findIngredientList(String lang){
        if (lang.equals("es")){
            return ingredientList_es;
        } else if (lang.equals("en")) {
            return ingredientList_en;
        }else {
            return ingredientList_es;
        }
    }


    public static List<IngredientEntity> findIngredientEntityList(String lang){
        if (lang.equals("es")){
            return ingredientEntityList_es;
        } else if (lang.equals("en")) {
            return ingredientEntityList_en;
        }else {
            return ingredientEntityList_es;
        }
    }
}
