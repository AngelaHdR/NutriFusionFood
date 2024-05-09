package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TypeTest {
    Type type;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @ParameterizedTest
    @CsvSource({"1,carne,meet","2,pescado,fish","3,lacteo,dairy","4,verdura,vegetable","5,fruta,fruit","6,hidrados,carbs"})
    @DisplayName("Constructor with 3 parameters")
    void createAllParameters(int id, String name_es, String name_en) {
        if (lang.equals("es")){
            type = new Type(id, name_es);
            assertAll(
                    ()->assertEquals(id, type.getId()),
                    ()->assertEquals(name_es, type.getName())
            );
        } else if (lang.equals("en")) {
            type = new Type(id, name_en);
            assertAll(
                    ()->assertEquals(id, type.getId()),
                    ()->assertEquals(name_en, type.getName())
            );
        }

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
