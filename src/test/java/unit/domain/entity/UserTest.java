package unit.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import com.fpmislata.NutriFusionFood.domain.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("Constructor void")
    void voidConstructor() {
        User user = new User();
    }
    @Test
    @DisplayName("Constructor 9 parameters")
    void createAllParameters() {
        User user = new User(1,"Jose","Perez","Garcia","1989-08-18", true,"p1","mail1","jose");
        assertAll(
                ()->assertEquals(1,user.getId()),
                ()->assertEquals("Jose",user.getName()),
                ()->assertEquals("Perez",user.getSurname1()),
                ()->assertEquals("Garcia",user.getSurname2()),
                ()->assertEquals("1989-08-18",user.getBirthDate()),
                ()->assertEquals(true,user.isNutritionist()),
                ()->assertEquals("p1",user.getPassword()),
                ()->assertEquals("mail1",user.getEmail()),
                ()->assertEquals("jose",user.getUsername())
        );
    }
}