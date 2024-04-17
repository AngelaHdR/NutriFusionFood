package unit.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.common.UserIoC;
import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

public class UserDaoUnitTest {
    UserDao userDao = UserIoC.getUserDao();

    @DisplayName("Find all the users from the database")
    @Test
    public void testFindAllUsers() {
        List<UserEntity> actualNutritionistList = userDao.findAllUser();
        List<UserEntity> expectedNutritionistList = new ArrayList<>(Arrays.asList(
            new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true,"pas1","mail1","jose"),
            new UserEntity(2,"Alicia","Fernandez","Lopez","2000-12-04", false, "pass2", "mail2", "alicia"),
            new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe"),
            new UserEntity(4,"Mercedes","Gil","Diaz","2000-04-14", false, "pass4", "mail4", "mercedes")));
        assertEquals(expectedNutritionistList, actualNutritionistList);
    }

    @DisplayName("Find only the nutritionists from the database")
    @Test
    public void testFindAllNutritionists() {
        List<UserEntity> actualNutritionistList = userDao.findAllNutritionist();
        List<UserEntity> expectedNutritionistList = new ArrayList<>(Arrays.asList(
            new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
            new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe")));
        assertEquals(expectedNutritionistList, actualNutritionistList);
    }

    @DisplayName("Find the nutritionists by its id")
    @Test
    public void testFindNutritionistById() {
        UserEntity actualNutritionist = userDao.findByIdNutritionist(1);
        UserEntity expectedNutritionist = new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose");
        assertEquals(expectedNutritionist, actualNutritionist);
    }

    @DisplayName("Insert a new user to the database")
    @Test
    public void testInsertNewUser() {
        userDao.insert(new UserEntity(5, "Marcos", "Monleon", "Miguel", "2005-10-06", true, "pass5", "mail5", "marcos"));
        List<UserEntity> actualUsersList = userDao.findAllUser();
        List<UserEntity> expectedUsersList = new ArrayList<>(Arrays.asList(
            new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
            new UserEntity(2,"Alicia","Fernandez","Lopez","2000-12-04", false, "pass2", "mail2", "alicia"),
            new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe"),
            new UserEntity(4,"Mercedes","Gil","Diaz","2000-04-14", false, "pass4", "mail4", "mercedes"),
            new UserEntity(5, "Marcos", "Monleon", "Miguel", "2005-10-06", true, "pass5", "mail5", "marcos")));
        assertEquals(expectedUsersList, actualUsersList);
    }
}
