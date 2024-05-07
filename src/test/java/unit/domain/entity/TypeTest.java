package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TypeTest {
    Type type;

    @ParameterizedTest
    @CsvSource({"1,carne,meet","2,pescado,fish","3,lacteo,dairy","4,verdura,vegetable","5,fruta,fruit","6,hidrados,carbs"})
    @DisplayName("Constructor with 3 parameters")
    void createAllParameters(int id, String name) {
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
    @DisplayName("Not allow to modify the name in spanish")
    void notModifyName() {
        type = new Type(1, "carne");
        type.setName("meat");
        assertEquals("carne", type.getName());
    }
}
