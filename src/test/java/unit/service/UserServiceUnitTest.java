package unit.service;

import com.fpmislata.NutriFusionFood.common.container.UserIoC;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import mock.repository.UserRepositoryMock;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserServiceUnitTest {
    private static UserService userService;

    @BeforeAll
    public static void setUpAll(){
        UserIoC.setUserRepository(new UserRepositoryMock());
        userService= UserIoC.getUserService();
    }
    @AfterAll
    public static void teardownAll(){
        UserIoC.reset();
    }

    @Test
    @DisplayName("Find all nutritionists")
    public void testFindAllNutritionist(){
        List<User> actualUserList = userService.findAllNutritionist();
        List<User> expectedUserList = new ArrayList<>(Arrays.asList(
                new User(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
                new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe")
                ));
        assertEquals(expectedUserList, actualUserList);
    }
    @Test
    @DisplayName("Find nutritionist by their id")
    public void testFindByIdNutritionist(){
        User actualUserList = userService.findByIdNutritionist(1);
        User expectedUserList = new User(1,"Jose","Perez","Garcia","1989-08-18", true,"p1","mail1","jose");
        assertEquals(expectedUserList,actualUserList);
    }
    @DisplayName("Return null for user id not nutritionist")
    @Test
    public void returnNullIdNotNutritionist(){
        User actualUser= userService.findByIdNutritionist(2);
        assertNull(actualUser);
    }
    @DisplayName("Return null for user id not in list")
    @ParameterizedTest
    @ValueSource(ints = {0,-2,8})
    public void returnNullWrongId(int id){
        User actualUser= userService.findByIdNutritionist(id);
        assertNull(actualUser);
    }
    @DisplayName("Find all the users in the database")
    @Test
    public void testFindAllUsers() {
        List<User> actualUserList = userService.findAllUser();
        List<User> expectedUserList = new ArrayList<>(Arrays.asList(
                new User(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
                new User(2,"Alicia","Fernandez","Lopez","2000-12-04", false, "pass2", "mail2", "alicia"),
                new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe"),
                new User(4,"Mercedes","Gil","Diaz","2000-04-14", false, "pass4", "mail4", "mercedes")
        ));
        assertEquals(expectedUserList, actualUserList);
    }

    @DisplayName("Insert new users into the database")
    @Test
    public void testInsertNewUser() {
        userService.insert(new User(5, "Marcos", "Monleon", "Miguel", "2005-10-06", false, "pass5", "mail5", "marcos"));
        List<User> actualUsersList = userService.findAllUser();
        List<User> expectedUsersList = new ArrayList<>(Arrays.asList(
                new User(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
                new User(2,"Alicia","Fernandez","Lopez","2000-12-04", false, "pass2", "mail2", "alicia"),
                new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe"),
                new User(4,"Mercedes","Gil","Diaz","2000-04-14", false, "pass4", "mail4", "mercedes"),
                new User(5, "Marcos", "Monleon", "Miguel", "2005-10-06", false, "pass5", "mail5", "marcos")));
        assertEquals(expectedUsersList, actualUsersList);
    }
}
