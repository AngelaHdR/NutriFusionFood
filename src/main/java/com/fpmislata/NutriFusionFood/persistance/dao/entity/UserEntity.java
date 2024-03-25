package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import java.time.LocalDate;
import java.util.Date;

public class UserEntity {
    private Integer id;
    private String name;
    private String surname1;
    private String surname2;
    private String birthDate;
    private Boolean nutritionist;

    public UserEntity(Integer id, String name, String surname1, String surname2, String birthDate, Boolean nutritionist) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birthDate = birthDate;
        this.nutritionist = nutritionist;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname1() {
        return this.surname1;
    }

    public String getSurname2() {
        return this.surname2;
    }



    public Boolean getNutritionist() {
        return this.nutritionist;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
