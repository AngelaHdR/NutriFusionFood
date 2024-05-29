package unit.persistance.dao.entity;

import static data.CategoryData.findCategoryEntityList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static data.TypeData.*;

import org.junit.jupiter.api.DisplayName;


import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class TypeEntityTest {
    TypeEntity typeEntity;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }


    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Constructor with 3 parameters")
    void createAllParameters(String lang) {
        int id = findTypeEntityList(lang).get(0).getId();
        String name = findTypeEntityList(lang).get(0).getName();
        typeEntity = new TypeEntity(id, name);
        assertAll(
                () -> assertEquals(id, typeEntity.getId()),
                () -> assertEquals(name, typeEntity.getName())
        );
    }
}
