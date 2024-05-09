package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

public class ToolEntityTest {
    ToolEntity toolEntity;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");
    @Test
    @DisplayName("Constructor with 3 parameters")
    void createConstructorAllParameters() {
        String name;
        if (lang.equals("es")){
            toolEntity = new ToolEntity(1, "sarten");
            name="sarten";
        } else if (lang.equals("en")) {
            toolEntity = new ToolEntity(1, "pan");
            name="pan";
        }else {
            name = null;
        }
        assertAll(
                () -> assertEquals(1, toolEntity.getId()),
                () -> assertEquals(name, toolEntity.getName())
        );
    }

}