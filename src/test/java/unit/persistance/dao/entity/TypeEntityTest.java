package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TypeEntityTest {
    TypeEntity typeEntity;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @ParameterizedTest
    @CsvSource({"1,carne,meet", "2,pescado,fish", "3,lacteo,dairy", "4,verdura,vegetable", "5,fruta,fruit", "6,hidrados,carbs"})
    @DisplayName("Constructor with 3 parameters")
    void createAllParameters(int id, String name_es,String name_en) {
        if (lang.equals("es")){
            typeEntity = new TypeEntity(id, name_es);
            assertAll(
                    () -> assertEquals(id, typeEntity.getId()),
                    () -> assertEquals(name_es, typeEntity.getName())
            );
        } else if (lang.equals("en")) {
            typeEntity = new TypeEntity(id, name_en);
            assertAll(
                    () -> assertEquals(id, typeEntity.getId()),
                    () -> assertEquals(name_en, typeEntity.getName())
            );
        }
    }
}
