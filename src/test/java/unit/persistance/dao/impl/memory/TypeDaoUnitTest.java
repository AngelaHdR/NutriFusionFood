package unit.persistance.dao.impl.memory;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import antiguo.memory.TypeDaoMemory;
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
            expectedList=List.of(
                    new TypeEntity(1,"carne"),
                    new TypeEntity(2,"pescado"),
                    new TypeEntity(3,"lacteo"),
                    new TypeEntity(4,"verdura"),
                    new TypeEntity(5,"fruta"),
                    new TypeEntity(6,"hidrados")
            );
        } else if (lang.equals("en")) {
            expectedList=List.of(
                    new TypeEntity(1,"meat"),
                    new TypeEntity(2,"fish"),
                    new TypeEntity(3,"dairy"),
                    new TypeEntity(4,"vegetable"),
                    new TypeEntity(5,"fruit"),
                    new TypeEntity(6,"carbs")
            );
        } else{
            expectedList = new ArrayList<>();
        }
        assertEquals(expectedList,actualList);
    }
    @Test
    @DisplayName("Find types for given id")
    public void testFindTypeById(){
        TypeEntity actualType = typeDao.findByIdType(5);
        String name;
        if (lang.equals("es")) {
            name = "fruta";
        }else if (lang.equals("en")) {
            name = "fruit";
        }else{
            name = null;
        }
        TypeEntity expectedType =   new TypeEntity(5,name);
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
