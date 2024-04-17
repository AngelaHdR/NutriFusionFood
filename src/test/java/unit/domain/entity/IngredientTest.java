package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Type;

public class IngredientTest {
    Ingredient ingredient;
    @Test
    void voidConstructor() {
        ingredient = new Ingredient(); 
    }

    @Test
    void createIngredientWithoutType() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
    }

    @Test
    void createIngredientWithType() {
        Type type = new Type(1, "verdura", "vegetable");
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2, type);
    }

    @Test
    void checkId() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
        assertEquals(1, ingredient.getId());
    }

    @Test
    void checkGluten() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
        assertEquals(false, ingredient.isGluten());
    }

    @Test
    void checkLactose() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
        assertEquals(false, ingredient.isLactose());
    }

    @Test
    void checkNameEs() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
        assertEquals("tomate", ingredient.getName_es());
    }

    @Test
    void checkNameEn() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
        assertEquals("tomato", ingredient.getName_en());
    }

    @Test
    void checkStartSeason() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
        assertEquals(1, ingredient.getStartSeason());
    }

    @Test
    void checkEndSeason() {
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2);
        assertEquals(2, ingredient.getEndSeason());
    }

    @Test
    void checkType() {
        Type type = new Type(1, "verdura", "vegetable");
        ingredient = new Ingredient(1, false, false, "tomate", "tomato", 1, 2, type);
        assertEquals(type, ingredient.getType());
    }
}