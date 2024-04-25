package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Type;

public class IngredientTest {
    Ingredient ingredient;
    @Test
    @DisplayName("Constructor void")
    void voidConstructor() {
        ingredient = new Ingredient(); 
    }

    @Test
    @DisplayName("Constructor with 7 parameters")
    void createIngredientWithoutType() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
        assertAll(
                ()->assertEquals(1, ingredient.getId()),
                ()->assertEquals(false, ingredient.isGluten()),
                ()->assertEquals(false, ingredient.isLactose()),
                ()->assertEquals("tomate", ingredient.getName_es()),
                ()->assertEquals("tomato", ingredient.getName_en()),
                ()->assertEquals(1, ingredient.getStartSeason()),
                ()->assertEquals(2, ingredient.getEndSeason())
        );
    }

    @Test
    @DisplayName("Constructor with 8 parameters")
    void createIngredientWithType() {
        Type type = new Type(1, "verdura", "vegetable");
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2, type);
        assertAll(
                ()->assertEquals(1, ingredient.getId()),
                ()->assertEquals(false, ingredient.isGluten()),
                ()->assertEquals(false, ingredient.isLactose()),
                ()->assertEquals("tomate", ingredient.getName_es()),
                ()->assertEquals("tomato", ingredient.getName_en()),
                ()->assertEquals(1, ingredient.getStartSeason()),
                ()->assertEquals(2, ingredient.getEndSeason()),
                ()->assertEquals(type, ingredient.getType())
        );
    }
}