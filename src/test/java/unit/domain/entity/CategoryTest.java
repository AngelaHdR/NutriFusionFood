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
    void createConstructorAllParameters(int id, String name) {
        category = new Category(id, name);
        assertAll(
                ()->assertEquals(id, category.getId()),
                ()->assertEquals(name, category.getName())
        );
    }
    @Test
    @DisplayName("Not allow to modify the id")
    void notModifyId() {
        category = new Category(1, "postre");
        category.setId(2);
        assertEquals(1, category.getId());
    }
    @Test
    @DisplayName("Not allow to modify the name in spanish")
    void notModifyNameEs() {
        category = new Category(1, "postre");
        category.setName("dessert");
        assertEquals("postre", category.getName());
    }

}