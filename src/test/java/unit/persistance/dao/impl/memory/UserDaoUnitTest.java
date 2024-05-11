package unit.persistance.dao.impl.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.memory.UserDaoMemory;
import data.UserData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserDaoUnitTest {
    UserDao userDao;
    @BeforeEach
    public void setUpAll(){
        userDao = new UserDaoMemory();
    }
    @AfterEach
    public void tearDownAll(){
        userDao = null;
    }
    @DisplayName("Find all the users from the database")
    @Test
    public void testFindAllUsers() {
        List<UserEntity> actualNutritionistList = userDao.findAllUser();
        List<UserEntity> expectedNutritionistList = UserData.userEntityList;
        assertEquals(expectedNutritionistList, actualNutritionistList);
    }

    @DisplayName("Find only the nutritionists from the database")
    @Test
    public void testFindAllNutritionists() {
        List<UserEntity> actualNutritionistList = userDao.findAllNutritionist();
        List<UserEntity> expectedNutritionistList = new ArrayList<>(Arrays.asList(
                UserData.userEntityList.get(0), UserData.userEntityList.get(2)));
            assertEquals(expectedNutritionistList, actualNutritionistList);
    }

    @DisplayName("Find the nutritionists by their id")
    @Test
    public void testFindNutritionistById() {
        UserEntity actualNutritionist = userDao.findByIdNutritionist(1);
        UserEntity expectedNutritionist = UserData.userEntityList.get(0);
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
        List<UserEntity> expectedUsersList = UserData.userEntityList;
        expectedUsersList.add(newUser);
        assertEquals(expectedUsersList, actualUsersList);
    }
}
