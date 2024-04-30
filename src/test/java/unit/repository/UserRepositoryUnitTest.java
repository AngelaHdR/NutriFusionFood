package unit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        User expectedUser = new User(1,"Jose","Perez","Garcia","1989-08-18", true,"p1","mail1","jose");
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
        List<User> expectedUserList = new ArrayList<>(Arrays.asList(
            new User(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
            new User(2,"Alicia","Fernandez","Lopez","2000-12-04", false, "pass2", "mail2", "alicia"),
            new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe"),
            new User(4,"Mercedes","Gil","Diaz","2000-04-14", false, "pass4", "mail4", "mercedes")
        ));
        assertEquals(expectedUserList, actualUserList);
    }

    @DisplayName("FInd all the nutritionists in the database")
    @Test
    public void testFindAllNutritionists() {
        List<User> actualNutritionistList = userRepository.findAllNutritionist();
        List<User> expectedNutritionistList = new ArrayList<>(Arrays.asList(
            new User(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
            new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe")
        ));
        assertEquals(expectedNutritionistList, actualNutritionistList);
    }

    @DisplayName("Insert new users into the database")
    @Test
    public void testInsertNewUser() {
        userRepository.insert(new User(5, "Marcos", "Monleon", "Miguel", "2005-10-06", true, "pass5", "mail5", "marcos"));
        List<User> actualUsersList = userRepository.findAllUser();
        List<User> expectedUsersList = new ArrayList<>(Arrays.asList(
            new User(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
            new User(2,"Alicia","Fernandez","Lopez","2000-12-04", false, "pass2", "mail2", "alicia"),
            new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe"),
            new User(4,"Mercedes","Gil","Diaz","2000-04-14", false, "pass4", "mail4", "mercedes"),
            new User(5, "Marcos", "Monleon", "Miguel", "2005-10-06", true, "pass5", "mail5", "marcos")));
        assertEquals(expectedUsersList, actualUsersList);
    }
}