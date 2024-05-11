package unit.persistance.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.UserData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.common.container.UserIoC;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;

import mock.dao.UserDaoMock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserRepositoryUnitTest {
    private static UserRepository userRepository;

    @BeforeAll
    public static void setupAll() {
        UserIoC.setUserDao(new UserDaoMock());
        userRepository = UserIoC.getUserRepository();

    }

    @AfterAll
    public static void teardownAll() {
        UserIoC.reset();
    }

    @DisplayName("Find nutritionists by their id")
    @Test
    public void testFindNutritionistById() {
        User actualUser = userRepository.findByIdNutritionist(1);
        User expectedUser = UserData.userList.get(0);
        assertEquals(expectedUser, actualUser);
    }
    @DisplayName("Return null for user id not nutritionist")
    @Test
    public void returnNullIdNotNutritionist(){
        User actualUser= userRepository.findByIdNutritionist(2);
        assertNull(actualUser);
    }
    @DisplayName("Return null for user id not in list")
    @ParameterizedTest
    @ValueSource(ints = {0,-2,8})
    public void returnNullWrongId(int id){
        User actualUser= userRepository.findByIdNutritionist(id);
        assertNull(actualUser);
    }

    @DisplayName("Find all the users in the database")
    @Test
    public void testFindAllUsers() {
        List<User> actualUserList = userRepository.findAllUser();
        List<User> expectedUserList = UserData.userList;
        assertEquals(expectedUserList, actualUserList);
    }

    @DisplayName("FInd all the nutritionists in the database")
    @Test
    public void testFindAllNutritionists() {
        List<User> actualNutritionistList = userRepository.findAllNutritionist();
        List<User> expectedNutritionistList = new ArrayList<>(Arrays.asList(
                UserData.userList.get(0),UserData.userList.get(2)));
        assertEquals(expectedNutritionistList, actualNutritionistList);
    }

    @DisplayName("Insert new users into the database")
    @Test
    public void testInsertNewUser() {
        User newUser = new User(5, "Marcos", "Monleon", "Miguel", "2005-10-06", false, "pass5", "mail5", "marcos");
        userRepository.insert(newUser);
        List<User> actualUsersList = userRepository.findAllUser();
        List<User> expectedUsersList = UserData.userList;
        expectedUsersList.add(newUser);
        assertEquals(expectedUsersList, actualUsersList);
    }
}