package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CategoryTest {
    Category category;
    @ParameterizedTest
    @CsvSource({"1,salado,main dish","2,postre,dessert","3,bebida,drink","4,snack,snack"})
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters(int id, String name_es, String name_en) {
        category = new Category(id, name_es, name_en);
        assertAll(
                ()->assertEquals(id, category.getId()),
                ()->assertEquals(name_es, category.getName_es()),
                ()->assertEquals(name_en, category.getName_en())
        );
    }
    @Test
    @DisplayName("Not allow to modify the id")
    void notModifyId() {
        category = new Category(1, "postre", "dessert");
        category.setId(2);
        assertEquals(1, category.getId());
    }
    @Test
    @DisplayName("Not allow to modify the name in spanish")
    void notModifyNameEs() {
        category = new Category(1, "postre", "dessert");
        category.setName_es("dessert");
        assertEquals("postre", category.getName_es());
    }
    @Test
    @DisplayName("Not allow to modify the name in english")
    void notModifyNameEn() {
        category = new Category(1, "postre", "dessert");
        category.setName_en("postre");
        assertEquals("dessert", category.getName_en());
    }
}