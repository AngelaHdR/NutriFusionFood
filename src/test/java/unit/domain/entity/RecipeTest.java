package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;

public class RecipeTest {
    Recipe recipe;

    @Test
    @DisplayName("Constructor void")
    void voidConstructor() {
        recipe = new Recipe();
    }

    @Test()
    @DisplayName("Constructor with 6 parameters")
    void createAllParameters() {
        recipe = new Recipe(1, "tortilla", "spanish", "receta tipica castellana", "paso 1", 120);
        assertAll(
                ()->assertEquals(1, recipe.getId()),
                ()->assertEquals("spanish", recipe.getLanguage()),
                ()->assertEquals("tortilla", recipe.getName()),
                ()->assertEquals("receta tipica castellana", recipe.getDescription()),
                ()->assertEquals("paso 1", recipe.getSteps()),
                ()->assertEquals(120, recipe.getTime())

        );
    }
}