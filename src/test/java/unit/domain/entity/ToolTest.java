package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;

public class ToolTest {
    @Test
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters() {
        Tool tool = new Tool(1, "sarten", "pan");
        assertAll(
                ()->assertEquals(1, tool.getId()),
                ()->assertEquals("sarten", tool.getName_es()),
                ()->assertEquals("pan", tool.getName_en())
        );
    }

}
