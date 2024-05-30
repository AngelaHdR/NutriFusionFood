package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.service.ToolService;
import com.fpmislata.NutriFusionFood.domain.service.impl.ToolServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.ToolDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.repository.ToolRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.impl.ToolRepositoryImpl;


public class ToolIoC {
    private static ToolService toolService;
    private static ToolRepository toolRepository;
    private static ToolDao toolDao;

    public static ToolService getToolService(){
        if (toolService==null) {
            toolService = new ToolServiceImpl(getToolRepository());
        }
        return toolService;
    }

    public static ToolRepository getToolRepository(){
        if (toolRepository==null) {
            toolRepository = new ToolRepositoryImpl(getToolDao());
        }
        return toolRepository;
    }

    public static ToolDao getToolDao(){
        if (toolDao==null){
            if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("jdbc")){
                toolDao = new ToolDaoJdbc();
            }
        }
        return toolDao;
    }

    public static void setToolService(ToolService toolService) {
        ToolIoC.toolService = toolService;
    }

    public static void setToolRepository(ToolRepository toolRepository) {
        ToolIoC.toolRepository = toolRepository;
    }

    public static void setToolDao(ToolDao toolDao) {
        ToolIoC.toolDao = toolDao;
    }
}
