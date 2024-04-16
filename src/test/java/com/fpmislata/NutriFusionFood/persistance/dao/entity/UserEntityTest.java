package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserEntityTest {
    UserEntity userEntity;

    @Test
    void createAllParameters() {
        userEntity = new UserEntity(1, "Soledad", "Berenguer", "Reyes", "2002-03-28", false);
    }

    @Test
    void checkId() {
        userEntity = new UserEntity(1, "Soledad", "Berenguer", "Reyes", "2002-03-28", false);
        assertEquals(1, userEntity.getId());
    }

    @Test
    void checkName() {
        userEntity = new UserEntity(1, "Soledad", "Berenguer", "Reyes", "2002-03-28", false);
        assertEquals("Soledad", userEntity.getName());
    }

    @Test
    void checkSurname1() {
        userEntity = new UserEntity(1, "Soledad", "Berenguer", "Reyes", "2002-03-28", false);
        assertEquals("Berenguer", userEntity.getSurname1());
    }

    @Test
    void checkSurname2() {
        userEntity = new UserEntity(1, "Soledad", "Berenguer", "Reyes", "2002-03-28", false);
        assertEquals("Reyes", userEntity.getSurname2());
    }

    @Test
    void checkBirthDate() {
        userEntity = new UserEntity(1, "Soledad", "Berenguer", "Reyes", "2002-03-28", false);
        assertEquals("2002-03-28", userEntity.getBirthDate());
    }

    @Test
    void checkNutritionist() {
        userEntity = new UserEntity(1, "Soledad", "Berenguer", "Reyes", "2002-03-28", false);
        assertEquals(false, userEntity.isNutritionist());
    }
}
