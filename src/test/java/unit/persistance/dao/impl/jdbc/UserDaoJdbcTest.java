package unit.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.UserDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.DBConnection;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.JdbcTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static data.UserData.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoJdbcTest extends JdbcTest {
    private static final UserDao userDao = new UserDaoJdbc();

    private static final DBConnection connection = DBConnection.getInstance();

    @BeforeAll
    static void setup() throws SQLException {
        /*connection.executeScript("bbdd_NFF_test.sql");
        connection.executeScript("inserts_NFF_test.sql");*/
        connection.getConnection().setAutoCommit(false);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.getConnection().rollback();
    }

    @DisplayName("Find all the users from the database")
    @Test
    public void testFindAllUsers() {
        List<UserEntity> actualNutritionistList = userDao.findAllUser();
        List<UserEntity> expectedNutritionistList = findUserEntityList();
        assertEquals(expectedNutritionistList, actualNutritionistList);
    }

    @DisplayName("Find only the nutritionists from the database")
    @Test
    public void testFindAllNutritionists() {
        List<UserEntity> actualNutritionistList = userDao.findAllNutritionist();
        List<UserEntity> expectedNutritionistList = new ArrayList<>(Arrays.asList(
                findUserEntityList().get(0), findUserEntityList().get(2)));
        assertEquals(expectedNutritionistList, actualNutritionistList);
    }

    @DisplayName("Find the nutritionists by their id")
    @Test
    public void testFindNutritionistById() {
        UserEntity actualNutritionist = userDao.findByIdNutritionist(1);
        UserEntity expectedNutritionist = findUserEntityList().get(0);
        assertEquals(expectedNutritionist, actualNutritionist);
    }
    @Test
    @DisplayName("Return null for clients")
    public void returnNullClientId(){
        UserEntity actualUser = userDao.findByIdNutritionist(2);
        assertNull(actualUser);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null for negative,zero or wrong id")
    public void returnNullWrongId(int id){
        UserEntity actualUser = userDao.findByIdNutritionist(id);
        assertNull(actualUser);
    }
    @DisplayName("Insert a new user to the database")
    @Test
    public void testInsertNewUser() {
        UserEntity newUser = new UserEntity(5, "Marcos", "Monleon", "Miguel", "2005-10-06", false, "pass5", "mail5", "marcos");
        userDao.insert(newUser);
        List<UserEntity> actualUsersList = userDao.findAllUser();
        List<UserEntity> expectedUsersList = new ArrayList<>(findUserEntityList());
        expectedUsersList.add(newUser);
        assertEquals(expectedUsersList, actualUsersList);
    }
}