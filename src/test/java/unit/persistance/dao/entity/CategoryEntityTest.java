package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CategoryEntityTest {
    CategoryEntity categoryEntity;
    @ParameterizedTest
    @CsvSource({"1,salado,main dish","2,postre,dessert","3,bebida,drink","4,snack,snack"})
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters(int id, String name_es, String name_en) {
        categoryEntity = new CategoryEntity(id, name_es, name_en);
        assertAll(
                ()->assertEquals(id, categoryEntity.getId()),
                ()->assertEquals(name_es, categoryEntity.getName_es()),
                ()->assertEquals(name_en, categoryEntity.getName_en())
        );

    }

    @Test
    void notModifyId() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        categoryEntity.setId(2);
        assertEquals(1, categoryEntity.getId());
    }
    @Test
    void notModifyNameEs() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        categoryEntity.setName_es("dessert");
        assertEquals("postre", categoryEntity.getName_es());
    }
    @Test
    void notModifyNameEn() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        categoryEntity.setName_en("postre");
        assertEquals("dessert", categoryEntity.getName_en());
    }
}