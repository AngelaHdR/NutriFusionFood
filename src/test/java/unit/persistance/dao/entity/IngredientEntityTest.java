package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static data.IngredientData.*;
import static data.TypeData.*;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class IngredientEntityTest {
    IngredientEntity ingredientEntity;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }


    @Test
    void voidConstructor() {
        ingredientEntity = new IngredientEntity();
    }


    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Constructor with 7 parameters")
    void createIngredientWithoutType(String lang) {
        String name = findIngredientEntityList(lang).get(0).getName();
        ingredientEntity = new IngredientEntity(1, false, false, name, 1, 2);
        assertAll(
                () -> assertEquals(1, ingredientEntity.getId()),
                () -> assertEquals(false, ingredientEntity.isGluten()),
                () -> assertEquals(false, ingredientEntity.isLactose()),
                () -> assertEquals(name, ingredientEntity.getName()),
                () -> assertEquals(1, ingredientEntity.getStartSeason()),
                () -> assertEquals(2, ingredientEntity.getEndSeason())
        );
    }

    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Constructor with 8 parameters")
    void createIngredientWithType(String lang) {
        String name = findIngredientEntityList(lang).get(0).getName();
        String typeName = findTypeEntityList(lang).get(3).getName();
        ingredientEntity = new IngredientEntity(1, false, false, name, 1, 2, new TypeEntity(4,typeName));

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