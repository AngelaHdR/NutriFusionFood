package data;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolData {
    public static final List<ToolEntity> toolEntityList_es = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchara"),
            new ToolEntity(2,"bol"),
            new ToolEntity(3,"sarten"),
            new ToolEntity(4,"olla"),
            new ToolEntity(5,"vaso medidor"),
            new ToolEntity(6,"batidora")
    ));
    public static final List<ToolEntity> toolEntityList_en = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"spoon"),
            new ToolEntity(2,"bowl"),
            new ToolEntity(3,"frying pan"),
            new ToolEntity(4,"pot"),
            new ToolEntity(5,"measuring cup"),
            new ToolEntity(6,"blender")
    ));
    public static final List<Tool> toolList_es = new ArrayList<>(Arrays.asList(
            new Tool(1,"cuchara"),
            new Tool(2,"bol"),
            new Tool(3,"sarten"),
            new Tool(4,"olla"),
            new Tool(5,"vaso medidor"),
            new Tool(6,"batidora")
    ));
    public static final List<Tool> toolList_en = new ArrayList<>(Arrays.asList(
            new Tool(1,"spoon"),
            new Tool(2,"bowl"),
            new Tool(3,"frying pan"),
            new Tool(4,"pot"),
            new Tool(5,"measuring cup"),
            new Tool(6,"blender")
    ));

    public static List<Tool> findToolList(String lang){
        if (lang.equals("es")){
            return toolList_es;
        } else if (lang.equals("en")) {
            return toolList_en;
        }else {
            return toolList_es;
        }
    }


    public static List<ToolEntity> findToolEntityList(String lang){
        if (lang.equals("es")){
            return toolEntityList_es;
        } else if (lang.equals("en")) {
            return toolEntityList_en;
        }else {
            return toolEntityList_es;
        }
    }
}
