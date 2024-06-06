package unit.domain.service;

import com.fpmislata.NutriFusionFood.common.container.UserIoC;
import com.fpmislata.NutriFusionFood.common.exceptions.BusinessException;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import data.UserData;
import mock.repository.UserRepositoryMock;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserServiceUnitTest {
    private static UserService userService;

    @BeforeEach
    public void setUpAll(){
        UserIoC.setUserRepository(new UserRepositoryMock());
        userService= UserIoC.getUserService();
    }
    @AfterEach
    public void teardownAll(){
        UserIoC.reset();
    }

    @Test
    @DisplayName("Find all nutritionists")
    public void testFindAllNutritionist(){
        List<User> actualUserList = userService.findAllNutritionist();
        List<User> expectedUserList = new ArrayList<>(Arrays.asList(
                UserData.userList.get(0), UserData.userList.get(2)));
        assertEquals(expectedUserList, actualUserList);
    }
    @Test
    @DisplayName("Find nutritionist by their id")
    public void testfindByIdUser(){
        User actualUserList = userService.findByIdUser(1);
        User expectedUserList = UserData.userList.get(0);
        assertEquals(expectedUserList,actualUserList);
    }

    @DisplayName("Throw exception for user id not in list")
    @ParameterizedTest
    @ValueSource(ints = {0,-2})
    public void throwExceptionWrongId(int id){
        assertThrows(BusinessException.class,()->userService.findByIdUser(id));
    }
    @DisplayName("Find all the users in the database")
    @Test
    public void testFindAllUsers() {
        List<User> actualUserList = userService.findAllUser();
        List<User> expectedUserList = UserData.userList;
        assertEquals(expectedUserList, actualUserList);
    }

    @DisplayName("Insert new users into the database")
    @Test
    public void testInsertNewUser() {
        User newUser = new User(5, "Marcos", "Monleon", "Miguel", "2005-10-06", false, "password5", "mail5", "marcos");
        userService.insert(newUser);
        List<User> actualUsersList = userService.findAllUser();
        List<User> expectedUsersList = new ArrayList<>(UserData.userList);
        expectedUsersList.add(newUser);
        assertEquals(expectedUsersList, actualUsersList);
    }
    @DisplayName("Not allow short password")
    @Test
    public void shortPasswordThrowException(){
        User newUser = new User(5, "Marcos", "Garcia", "Lopez", "2005-10-06", false, "pas5", "mail5", "pepe");
        assertThrows(BusinessException.class,()->userService.insert(newUser));
    }
}
