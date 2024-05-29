package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static data.ToolData.*;

import org.junit.jupiter.api.DisplayName;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class ToolEntityTest {
    ToolEntity toolEntity;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }

    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters(String lang) {
        String name = findToolEntityList(lang).get(0).getName();
        toolEntity = new ToolEntity(1, name);
        assertAll(
                () -> assertEquals(1, toolEntity.getId()),
                () -> assertEquals(name, toolEntity.getName())
        );
    }

}