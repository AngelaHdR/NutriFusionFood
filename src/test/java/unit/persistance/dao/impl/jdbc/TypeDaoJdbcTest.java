package unit.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.TypeDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.DBConnection;

import data.TypeData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.JdbcTest;

import java.sql.SQLException;
import java.util.List;

import static data.TypeData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TypeDaoJdbcTest extends JdbcTest {
    private static final TypeDao typeDao = new TypeDaoJdbc();

    private static final DBConnection connection = DBConnection.getInstance();
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }

    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Find all types")
    public void testFindAllTypes(String lang){
        List<TypeEntity> actualList = typeDao.findAllType();
        List<TypeEntity> expectedList = findTypeEntityList(lang);
        assertEquals(expectedList,actualList);
    }
    @ParameterizedTest
    @MethodSource("availableLanguages")
    @DisplayName("Find types for given id")
    public void testFindTypeById(String lang){
        TypeEntity actualType = typeDao.findByIdType(5);
        TypeEntity expectedType = findTypeEntityList(lang).get(4);
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