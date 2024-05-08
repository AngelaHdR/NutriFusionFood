package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

public class IngredientEntityTest {
    IngredientEntity ingredientEntity;

    @Test
    void voidConstructor() {
        ingredientEntity = new IngredientEntity();
    }


    @Test
    @DisplayName("Constructor with 7 parameters")
    void createIngredientWithoutType() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", 1, 2);
        assertAll(
                () -> assertEquals(1, ingredientEntity.getId()),
                () -> assertEquals(false, ingredientEntity.isGluten()),
                () -> assertEquals(false, ingredientEntity.isLactose()),
                () -> assertEquals("tomate", ingredientEntity.getName()),
                () -> assertEquals(1, ingredientEntity.getStartSeason()),
                () -> assertEquals(2, ingredientEntity.getEndSeason())
        );
    }

    @Test
    @DisplayName("Constructor with 8 parameters")
    void createIngredientWithType() {

        ingredientEntity = new IngredientEntity(1, false, false, "tomate", 1, 2, new TypeEntity());
        assertAll(
                () -> assertEquals(1, ingredientEntity.getId()),
                () -> assertEquals(false, ingredientEntity.isGluten()),
                () -> assertEquals(false, ingredientEntity.isLactose()),
                () -> assertEquals("tomate", ingredientEntity.getName()),
                () -> assertEquals(1, ingredientEntity.getStartSeason()),
                () -> assertEquals(2, ingredientEntity.getEndSeason()),
                () -> assertEquals(1, ingredientEntity.getType())
        );
    }

    @Test
    void createIngredientEntityWithoutType() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", 1, 2);
    }

    @Test
    void createIngredientEntityWithType() {
        ingredientEntity = new IngredientEntity(1, false, false, "tomate", 1, 2, new TypeEntity());
    }
}