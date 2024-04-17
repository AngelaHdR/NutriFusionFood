package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class UserEntity {
    private Integer id;
    private String name;
    private String surname1;
    private String surname2;
    private String birthDate;
    private Boolean nutritionist;
    private String password;
    private String email;
    private String username;

    //Constructor
    public UserEntity(Integer id, String name, String surname1, String surname2, String birthDate, Boolean nutritionist, String password, String email, String username) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birthDate = birthDate;
        this.nutritionist = nutritionist;
        this.password = password;
        this.email = email;
        this.username = username;
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

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
