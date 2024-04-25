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
    void createAllParameters(int id, String name_es, String name_en) {
        type = new Type(id, name_es, name_en);
        assertAll(
                ()->assertEquals(id, type.getId()),
                ()->assertEquals(name_es, type.getName_es()),
                ()->assertEquals(name_en, type.getName_en())
        );
    }
    @Test
    @DisplayName("Not allow to modify the id")
    void notModifyId() {
        type = new Type(1, "carne", "meat");
        type.setId(2);
        assertEquals(1, type.getId());
    }
    @Test
    @DisplayName("Not allow to modify the name in spanish")
    void notModifyNameEs() {
        type = new Type(1, "carne", "meat");
        type.setName_es("meat");
        assertEquals("carne", type.getName_es());
    }
    @Test
    @DisplayName("Not allow to modify the name in english")
    void notModifyNameEn() {
        type = new Type(1, "carne", "meat");
        type.setName_en("carne");
        assertEquals("meat", type.getName_en());
    }
}
