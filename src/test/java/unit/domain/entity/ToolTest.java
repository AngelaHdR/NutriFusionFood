package unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;

public class ToolTest {
    Tool tool;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");
    @Test
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters() {
        String name;
        if (lang.equals("es")){
            tool = new Tool(1, "sarten");
            name="sarten";
        } else if (lang.equals("en")) {
            tool = new Tool(1, "pan");
            name="pan";
        } else {
            name = null;
        }
        assertAll(
                ()->assertEquals(1, tool.getId()),
                ()->assertEquals(name, tool.getName())
        );
    }

}
