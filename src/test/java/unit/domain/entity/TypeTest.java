package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Type;

public class TypeTest {
    Type type;

    @Test
    void createAllParameters() {
        type = new Type(1, "verdura", "vegetable");
    }

    @Test
    void checkId() {
        type = new Type(1, "verdura", "vegetable");
        assertEquals(1, type.getId());
    }

    @Test
    void checkNameEs() {
        type = new Type(1, "verdura", "vegetable");
        assertEquals("verdura", type.getName_es());
    }

    @Test
    void checkNameEn() {
        type = new Type(1, "verdura", "vegetable");
        assertEquals("vegetable", type.getName_en());
    }
}
