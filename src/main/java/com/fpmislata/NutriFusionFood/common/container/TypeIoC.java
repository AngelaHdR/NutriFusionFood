package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.service.TypeService;
import com.fpmislata.NutriFusionFood.domain.service.impl.TypeServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.TypeDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.repository.TypeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.impl.TypeRepositoryImpl;

public class TypeIoC {
    private static TypeService typeService;
    private static TypeRepository typeRepository;
    private static TypeDao typeDao;

    public static TypeService getTypeService(){
        if (typeService==null) {
            typeService = new TypeServiceImpl(getTypeRepository());
        }
        return typeService;
    }

    public static TypeRepository getTypeRepository(){
        if (typeRepository==null) {
            typeRepository = new TypeRepositoryImpl(getTypeDao());
        }
        return typeRepository;
    }

    public static TypeDao getTypeDao(){
        if (typeDao==null){
            if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("jdbc")) {
                typeDao = new TypeDaoJdbc();
            }
        }
        return typeDao;
    }
    public static void setTypeService(TypeService typeService) {
        TypeIoC.typeService = typeService;
    }
    public static void setTypeRepository(TypeRepository typeRepository) {
        TypeIoC.typeRepository = typeRepository;
    }
    public static void setTypeDao(TypeDao typeDao) {
        TypeIoC.typeDao = typeDao;
    }
    public static void reset() {
        typeService = null;
        typeRepository = null;
        typeDao = null;
    }
}
