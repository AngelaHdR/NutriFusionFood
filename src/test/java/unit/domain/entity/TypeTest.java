package unit.domain.entity;

import static data.TypeData.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class TypeTest {
    Type type;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }


    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Constructor with 3 parameters")
    void createAllParameters(String lang) {
        int id = findTypeList(lang).get(0).getId();
        String name = findTypeList(lang).get(0).getName();
        type = new Type(id, name);
        assertAll(
                ()->assertEquals(id, type.getId()),
                ()->assertEquals(name, type.getName())
        );
    }
    @Test
    @DisplayName("Not allow to modify the id")
    void notModifyId() {
        type = new Type(1, "carne");
        type.setId(2);
        assertEquals(1, type.getId());
    }
    @Test
    @DisplayName("Not allow to modify the name")
    void notModifyName() {
        type = new Type(1, "carne");
        type.setName("meat");
        assertEquals("carne", type.getName());
    }
}
