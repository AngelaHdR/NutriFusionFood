package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static data.CategoryData.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CategoryEntityTest {
    CategoryEntity categoryEntity;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }
    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters(String lang) {
        int id = findCategoryEntityList(lang).get(0).getId();
        String name = findCategoryEntityList(lang).get(0).getName();
        categoryEntity = new CategoryEntity(id, name);
        assertAll(
                ()->assertEquals(id, categoryEntity.getId()),
                ()->assertEquals(name, categoryEntity.getName())
        );
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