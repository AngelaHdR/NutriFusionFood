package unit.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.CategoryDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.DBConnection;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.SQLException;
import java.util.List;

import static data.CategoryData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CategoryDaoJdbcTest {
    private static final CategoryDao categoryDao = new CategoryDaoJdbc();

    private static final DBConnection connection = DBConnection.getInstance();

    @BeforeAll
    static void setup() throws SQLException {
        connection.executeScript("schemaNFFtest.sql");
        connection.executeScript("dataNFFtest.sql");
        connection.getConnection().setAutoCommit(false);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.getConnection().rollback();
    }

    CategoryEntity categoryEntity;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }
    @DisplayName("Find all the categories in the database")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindAllCategories(String lang) {
        List<CategoryEntity> actualCategoryList = categoryDao.findAllCategory();
        List<CategoryEntity> expectedCategoryList = findCategoryEntityList(lang);
        assertEquals(expectedCategoryList, actualCategoryList);
    }

    @DisplayName("Find categories by their id")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindCategoryById(String lang) {
        CategoryEntity actualCategory = categoryDao.findByIdCategory(1);
        CategoryEntity expectedCategory = findCategoryEntityList(lang).get(0);
        assertEquals(expectedCategory, actualCategory);
    }
    @Test
    @DisplayName("Return null for negative,zero or wrong id")
    public void returnNullWrongId(){
        CategoryEntity actualCategory = categoryDao.findByIdCategory(-3);
        assertNull(actualCategory);
    }

}