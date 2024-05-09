package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

public class IngredientEntityTest {
    IngredientEntity ingredientEntity;

    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @Test
    void voidConstructor() {
        ingredientEntity = new IngredientEntity();
    }


    @Test
    @DisplayName("Constructor with 7 parameters")
    void createIngredientWithoutType() {
        String name;
        if (lang.equals("es")) {
            ingredientEntity = new IngredientEntity(1, false, false, "tomate", 1, 2);
            name="tomate";
        }else if (lang.equals("en")) {
            ingredientEntity = new IngredientEntity(1, false, false, "tomato", 1, 2);
            name="tomato";
        }else {
            name = null;
        }
        assertAll(
                () -> assertEquals(1, ingredientEntity.getId()),
                () -> assertEquals(false, ingredientEntity.isGluten()),
                () -> assertEquals(false, ingredientEntity.isLactose()),
                () -> assertEquals(name, ingredientEntity.getName()),
                () -> assertEquals(1, ingredientEntity.getStartSeason()),
                () -> assertEquals(2, ingredientEntity.getEndSeason())
        );
    }

    @Test
    @DisplayName("Constructor with 8 parameters")
    void createIngredientWithType() {
        String name;
        String typeName;
        if (lang.equals("es")) {
            ingredientEntity = new IngredientEntity(1, false, false, "tomate", 1, 2, new TypeEntity(1,"verdura"));
            name="tomate";
            typeName="verdura";
        }else if (lang.equals("en")) {
            ingredientEntity = new IngredientEntity(1, false, false, "tomato", 1, 2, new TypeEntity(1,"vegetable"));
            name="tomato";
            typeName="vegetable";
        }else {
            name = null;
            typeName = null;
        }

        assertAll(
                () -> assertEquals(1, ingredientEntity.getId()),
                () -> assertEquals(false, ingredientEntity.isGluten()),
                () -> assertEquals(false, ingredientEntity.isLactose()),
                () -> assertEquals(name, ingredientEntity.getName()),
                () -> assertEquals(1, ingredientEntity.getStartSeason()),
                () -> assertEquals(2, ingredientEntity.getEndSeason()),
                () -> assertEquals(typeName, ingredientEntity.getType().getName())
        );
    }
}