package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

public class IngredientEntityTest {
    IngredientEntity ingredientEntity;

    @Test
    void voidConstructor() {
        ingredientEntity = new IngredientEntity();
    }

    @Test
    void createIngredientEntityWithoutType() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2);
    }

    @Test
    void createIngredientEntityWithType() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
    }

    @Test
    void checkId() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
        assertEquals(1, ingredientEntity.getId());
    }

    @Test
    void checkGluten() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
        assertEquals(false, ingredientEntity.isGluten());
    }

    @Test
    void checkLactose() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
        assertEquals(false, ingredientEntity.isLactose());
    }

    @Test
    void checkNameEs() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
        assertEquals("tomate", ingredientEntity.getName_es());
    }

    @Test
    void checkNameEn() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
        assertEquals("tomato", ingredientEntity.getName_en());
    }

    @Test
    void checkStartSeason() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
        assertEquals(1, ingredientEntity.getStartSeason());
    }

    @Test
    void checkEndSeason() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
        assertEquals(2, ingredientEntity.getEndSeason());
    }

    @Test
    void checkType() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", "tomato", 1, 2, 1);
        assertEquals(1, ingredientEntity.getTypeId());
    }
}
