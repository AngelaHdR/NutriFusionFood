package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static data.IngredientData.*;
import static data.TypeData.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class IngredientTest {
    Ingredient ingredient;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }
    @Test
    @DisplayName("Constructor void")
    void voidConstructor() {
        ingredient = new Ingredient(); 
    }

    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Constructor with 7 parameters")
    void createIngredientWithoutType(String lang) {
        String name = findIngredientList(lang).get(0).getName();
        ingredient = new Ingredient(1, false, false, name, 1, 2);
        assertAll(
                ()->assertEquals(1, ingredient.getId()),
                ()->assertEquals(false, ingredient.isGluten()),
                ()->assertEquals(false, ingredient.isLactose()),
                ()->assertEquals(name, ingredient.getName()),
                ()->assertEquals(1, ingredient.getStartSeason()),
                ()->assertEquals(2, ingredient.getEndSeason())
        );
    }

    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Constructor with 8 parameters")
    void createIngredientWithType(String lang) {
        String name = findIngredientList(lang).get(0).getName();
        String typeName = findTypeList(lang).get(3).getName();
        Type type = new Type(1, typeName);
        ingredient = new Ingredient(1, false, false, name, 1, 2, type);
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