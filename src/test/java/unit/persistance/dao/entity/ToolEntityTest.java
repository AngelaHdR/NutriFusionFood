package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

public class ToolEntityTest {
    ToolEntity toolEntity;

    @Test
    void createAllParameters() {
        toolEntity = new ToolEntity(1, "sarten", "pan");
    }

    @Test
    void checkId() {
        toolEntity = new ToolEntity(1, "sarten", "pan");
        assertEquals(1, toolEntity.getId());
    }

    @Test
    void checkNameEs() {
        toolEntity = new ToolEntity(1, "sarten", "pan");
        assertEquals("sarten", toolEntity.getName_es());
    }

    @Test
    void checkNameEn() {
        toolEntity = new ToolEntity(1, "sarten", "pan");
        assertEquals("pan", toolEntity.getName_en());
    }
}