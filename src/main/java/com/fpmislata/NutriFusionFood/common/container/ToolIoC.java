package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.ToolDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.ToolDaoMemory;

public class ToolIoC {
    private static ToolDao toolDao;
    public static ToolDao getToolDao(){
        if (toolDao==null){
            if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("jdbc")){
                toolDao = new ToolDaoJdbc();
            }else if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("memory")) {
                toolDao = new ToolDaoMemory();
            }
        }
        return toolDao;
    }
}
