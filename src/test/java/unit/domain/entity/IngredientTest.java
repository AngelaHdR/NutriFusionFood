package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Type;

public class IngredientTest {
    Ingredient ingredient;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");
    @Test
    @DisplayName("Constructor void")
    void voidConstructor() {
        ingredient = new Ingredient(); 
    }

    @Test
    @DisplayName("Constructor with 7 parameters")
    void createIngredientWithoutType() {
        String name;
        if (lang.equals("es")){
            ingredient = new Ingredient(1, false, false, "tomate", 1, 2);
            name="tomate";
        } else if (lang.equals("en")) {
            ingredient = new Ingredient(1, false, false, "tomato", 1, 2);
            name="tomato";
        } else {
            name = null;
        }
        assertAll(
                ()->assertEquals(1, ingredient.getId()),
                ()->assertEquals(false, ingredient.isGluten()),
                ()->assertEquals(false, ingredient.isLactose()),
                ()->assertEquals(name, ingredient.getName()),
                ()->assertEquals(1, ingredient.getStartSeason()),
                ()->assertEquals(2, ingredient.getEndSeason())
        );
    }

    @Test
    @DisplayName("Constructor with 8 parameters")
    void createIngredientWithType() {
        String name;
        String typeName;
        if (lang.equals("es")){
            Type type = new Type(1, "verdura");
            ingredient = new Ingredient(1, false, false, "tomate", 1, 2, type);
            name="tomate";
            typeName="verdura";
        } else if (lang.equals("en")) {
            Type type = new Type(1, "vegetable");
            ingredient = new Ingredient(1, false, false, "tomato", 1, 2, type);
            name="tomato";
            typeName="vegetable";
        } else {
            name = null;
            typeName = null;
        }

        assertAll(
                ()->assertEquals(1, ingredient.getId()),
                ()->assertEquals(false, ingredient.isGluten()),
                ()->assertEquals(false, ingredient.isLactose()),
                ()->assertEquals(name, ingredient.getName()),
                ()->assertEquals(1, ingredient.getStartSeason()),
                ()->assertEquals(2, ingredient.getEndSeason()),
                ()->assertEquals(typeName, ingredient.getType().getName())
        );
    }
}