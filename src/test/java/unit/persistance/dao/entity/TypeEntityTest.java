package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.domain.entity.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TypeEntityTest {
    TypeEntity typeEntity;

    @ParameterizedTest
    @CsvSource({"1,carne,meet", "2,pescado,fish", "3,lacteo,dairy", "4,verdura,vegetable", "5,fruta,fruit", "6,hidrados,carbs"})
    @DisplayName("Constructor with 3 parameters")
    void createAllParameters(int id, String name) {
        typeEntity = new TypeEntity(id, name);
        assertAll(
                () -> assertEquals(id, typeEntity.getId()),
                () -> assertEquals(name, typeEntity.getName())
        );
    }
}
