package unit.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fpmislata.NutriFusionFood.domain.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

public class UserEntityTest {
    @Test
    @DisplayName("Constructor 9 parameters")
    void createAllParameters() {
        UserEntity userEntity = new UserEntity(1, "Jose", "Perez", "Garcia", "1989-08-18", true, "p1", "mail1", "jose");
        assertAll(
                () -> assertEquals(1, userEntity.getId()),
                () -> assertEquals("Jose", userEntity.getName()),
                () -> assertEquals("Perez", userEntity.getSurname1()),
                () -> assertEquals("Garcia", userEntity.getSurname2()),
                () -> assertEquals("1989-08-18", userEntity.getBirthDate()),
                () -> assertEquals(true, userEntity.isNutritionist()),
                () -> assertEquals("p1", userEntity.getPassword()),
                () -> assertEquals("mail1", userEntity.getEmail()),
                () -> assertEquals("jose", userEntity.getUsername())
        );
    }
}
