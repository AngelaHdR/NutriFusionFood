package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;

public class RecipeEntityTest {
    RecipeEntity recipeEntity;

    @Test()
    @DisplayName("Constructor with 6 parameters")
    void createAllParameters() {
        UserEntity userEntity = new UserEntity(1, "Jose", "Perez", "Garcia", "1989-08-18", true, "p1", "mail1", "jose");
        CategoryEntity categoryEntity = new CategoryEntity(1,"salado");
        recipeEntity = new RecipeEntity(1, "Tortilla patata", "es", "receta tipica castellana", "Paso 1", 120, userEntity, categoryEntity);

        assertAll(
                () -> assertEquals(1, recipeEntity.getId()),
                () -> assertEquals("es", recipeEntity.getLanguage()),
                () -> assertEquals("Tortilla patata", recipeEntity.getName()),
                () -> assertEquals("receta tipica castellana", recipeEntity.getDescription()),
                () -> assertEquals("paso 1", recipeEntity.getSteps()),
                () -> assertEquals(120, recipeEntity.getTime()),
                () -> assertEquals(1, recipeEntity.getUser().getId()),
                () -> assertEquals(1, recipeEntity.getCategory().getId())

        );
    }
}
