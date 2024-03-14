package com.fpmislata.NutriFusionFood.domain.entity;

import java.time.LocalDate;

public class User {
    private Integer id;
    private String name;
    private String surname1;
    private String surname2;
    private LocalDate birthDate;
    private Boolean nutritionist;

    public User(Integer id, String name, String surname1, String surname2, LocalDate birthDate, Boolean nutritionist) {
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

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public Boolean getNutritionist() {
        return this.nutritionist;
    }
}
