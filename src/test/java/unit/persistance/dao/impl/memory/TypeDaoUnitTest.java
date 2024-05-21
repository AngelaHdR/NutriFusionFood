package unit.persistance.dao.impl.memory;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.TypeDaoMemory;
import data.TypeData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

public class TypeDaoUnitTest {
    TypeDao typeDao = new TypeDaoMemory();
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @Test
    @DisplayName("Find all types")
    public void testFindAllTypes(){
        List<TypeEntity> actualList = typeDao.findAllType();
        List<TypeEntity> expectedList;
        if (lang.equals("es")){
            expectedList= TypeData.typeEntityList_es;
        } else if (lang.equals("en")) {
            expectedList=TypeData.typeEntityList_en;
        } else{
            expectedList = new ArrayList<>();
        }
        assertEquals(expectedList,actualList);
    }
    @Test
    @DisplayName("Find types for given id")
    public void testFindTypeById(){
        TypeEntity actualType = typeDao.findByIdType(5);
        TypeEntity expectedType;
        if (lang.equals("es")) {
            expectedType = TypeData.typeEntityList_es.get(4);
        }else if (lang.equals("en")) {
            expectedType = TypeData.typeEntityList_en.get(4);
        }else{
            expectedType = null;
        }
        assertEquals(expectedType, actualType);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-8,28})
    @DisplayName("Return null for negative,zero or wrong id")
    public void returnNullWrongId(int id){
        TypeEntity actualType = typeDao.findByIdType(id);
        assertNull(actualType);
    }

}
