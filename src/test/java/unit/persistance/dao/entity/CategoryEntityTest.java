package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CategoryEntityTest {
    CategoryEntity categoryEntity;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");
    @ParameterizedTest
    @CsvSource({"1,salado,main dish","2,postre,dessert","3,bebida,drink","4,snack,snack"})
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters(int id, String name_es,String name_en) {
        if (lang.equals("es")){
            categoryEntity = new CategoryEntity(id, name_es);
            assertAll(
                    ()->assertEquals(id, categoryEntity.getId()),
                    ()->assertEquals(name_es, categoryEntity.getName())
            );
        } else if (lang.equals("en")) {
            categoryEntity = new CategoryEntity(id, name_en);
            assertAll(
                    () -> assertEquals(id, categoryEntity.getId()),
                    () -> assertEquals(name_en, categoryEntity.getName())
            );
        }
    }

    @Test
    void notModifyId() {
        categoryEntity = new CategoryEntity(1, "postre");
        categoryEntity.setId(2);
        assertEquals(1, categoryEntity.getId());
    }
    @Test
    void notModifyName() {
        categoryEntity = new CategoryEntity(1, "postre");
        categoryEntity.setName("dessert");
        assertEquals("postre", categoryEntity.getName());
    }

}