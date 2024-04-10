package com.fpmislata.NutriFusionFood.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    /*
   @Test
   @DisplayName("Create class user")
   void createClass(){
       User user= new User();
   }*/
    User user = new User();
    @Nested
    class ConstructorTest {
        @DisplayName("Create All parameters")
        @Test
        void createAllParameters() {
            user = new User(1,"Soledad","Berenguer","Reyes","2002-03-28",false);
        }
        @Test
        @DisplayName("Verify the name")
        void checkName(){
            user = new User(1,"Soledad","Berenguer","Reyes","2002-03-28",false);
            assertEquals("Soledad",user.getName());
        }
        @Test
        @DisplayName("Verify the surname")
        void checkName1(){
            user = new User(1,"Soledad","Berenguer","Reyes","2002-03-28",false);
            assertEquals("Soledad",user.getName());
        }
        @DisplayName("")
        @ParameterizedTest()

        void checkUser(){
            user = new User(1,"Soledad","Berenguer","Reyes","2002-03-28",false);

        }


    }

}