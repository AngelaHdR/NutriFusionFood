package com.fpmislata.NutriFusionFood.domain.entity;

public class User {
    private Integer id;
    private String name;
    private String surname1;
    private String surname2;
    private String birthDate;
    private Boolean nutritionist;

    //Constructors (void and all parameters)
    public User() {
    }
    public User(Integer id, String name, String surname1, String surname2, String birthDate, Boolean nutritionist) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birthDate = birthDate;
        this.nutritionist = nutritionist;
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return this.surname1;
    }
    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return this.surname2;
    }
    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean isNutritionist() {
        return this.nutritionist;
    }
    public void setNutritionist(Boolean nutritionist) {
        this.nutritionist = nutritionist;
    }

}
