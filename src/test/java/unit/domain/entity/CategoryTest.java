package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import data.CategoryData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CategoryTest {
    Category category;

    private String lang = AppPropertiesReader.getInstance().getProperty("lang");
    @ParameterizedTest
    @CsvSource({"1,salado,main dish","2,postre,dessert","3,bebida,drink","4,snack,snack"})
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters(int id, String name_es, String name_en) {
        if (lang.equals("es")){
            category = new Category(id, name_es);
            assertAll(
                    ()->assertEquals(id, category.getId()),
                    ()->assertEquals(name_es, category.getName())
            );
        } else if (lang.equals("en")) {
            category = new Category(id, name_en);
            assertAll(
                    ()->assertEquals(id, category.getId()),
                    ()->assertEquals(name_en, category.getName())
            );
        }
    }
    @Test
    @DisplayName("Not allow to modify the id")
    void notModifyId() {
        category = CategoryData.categoryList_es.get(0);
        category.setId(2);
        assertEquals(1, category.getId());
    }
    @Test
    @DisplayName("Not allow to modify the name")
    void notModifyNameEs() {
        category = CategoryData.categoryList_es.get(0);
        category.setName("postre");
        assertEquals("salado", category.getName());
    }

}