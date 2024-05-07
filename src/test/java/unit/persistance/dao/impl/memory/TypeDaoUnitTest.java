package unit.persistance.dao.impl.memory;

import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.TypeDaoMemory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

public class TypeDaoUnitTest {
    TypeDao typeDao = new TypeDaoMemory();
    @Test
    @DisplayName("Find all types")
    public void testFindAllTypes(){
        List<TypeEntity> actualList = typeDao.findAllType();
        List<TypeEntity> expectedList = List.of(
                new TypeEntity(1,"carne"),
                new TypeEntity(2,"pescado"),
                new TypeEntity(3,"lacteo"),
                new TypeEntity(4,"verdura"),
                new TypeEntity(5,"fruta"),
                new TypeEntity(6,"hidrados")
        );
        assertEquals(expectedList,actualList);
    }
    @Test
    @DisplayName("Find types for given id")
    public void testFindTypeById(){
        TypeEntity actualType = typeDao.findByIdType(5);
        TypeEntity expectedType =   new TypeEntity(5,"fruta");
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
