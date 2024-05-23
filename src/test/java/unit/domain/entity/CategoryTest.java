package unit.domain.entity;

import static data.CategoryData.*;

import i18n.AvailableLanguage;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CategoryTest {
    Category category;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }

    @Test
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters() {
        category = new Category(1, "recipe");
        assertAll(
                ()->assertEquals(1, category.getId()),
                ()->assertEquals("recipe", category.getName())
        );
    }
    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Not allow to modify the id")
    void notModifyId(String lang) {
        category = findCategoryList(lang).get(0);
        category.setId(2);
        assertEquals(1, category.getId());
    }
    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Not allow to modify the name")
    void notModifyNameEs(String lang) {
        category = findCategoryList(lang).get(0);
        category.setName("postre");
        assertEquals(findCategoryList(lang).get(0).getName(), category.getName());
    }

}