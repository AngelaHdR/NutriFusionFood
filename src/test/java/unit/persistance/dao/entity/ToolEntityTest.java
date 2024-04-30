package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

public class ToolEntityTest {
    ToolEntity toolEntity;

    @Test
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters() {
        ToolEntity toolEntity = new ToolEntity(1, "sarten", "pan");
        assertAll(
                () -> assertEquals(1, toolEntity.getId()),
                () -> assertEquals("sarten", toolEntity.getName_es()),
                () -> assertEquals("pan", toolEntity.getName_en())
        );
    }

}