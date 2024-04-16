package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class IngredientEntity {
    private Integer id;
    private Boolean gluten;
    private Boolean lactose;
    private String name_es;
    private String name_en;
    private Integer startSeason;
    private Integer endSeason;
    private Integer typeId;

    //Constructors (void, basic parameters and all parameters)
    public IngredientEntity() {
    }
    public IngredientEntity(Integer id, Boolean gluten, Boolean lactose, String name_es, String name_en, Integer startSeason, Integer endSeason) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name_es = name_es;
        this.name_en = name_en;
        this.startSeason = startSeason;
        this.endSeason = endSeason;
    }
    public IngredientEntity(Integer id, Boolean gluten, Boolean lactose, String name_es, String name_en, Integer startSeason, Integer endSeason, Integer typeId) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name_es = name_es;
        this.name_en = name_en;
        this.startSeason = startSeason;
        this.endSeason = endSeason;
        this.typeId = typeId;
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isGluten() {
        return this.gluten;
    }
    public void setGluten(Boolean gluten) {
        this.gluten = gluten;
    }

    public Boolean isLactose() {
        return this.lactose;
    }
    public void setLactose(Boolean lactose) {
        this.lactose = lactose;
    }

    public String getName_es() {
        return name_es;
    }
    public void setName_es(String name_es) {
        this.name_es = name_es;
    }

    public String getName_en() {
        return name_en;
    }
    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public Integer getStartSeason() {
        return startSeason;
    }
    public void setStartSeason(Integer startSeason) {
        this.startSeason = startSeason;
    }

    public Integer getEndSeason() {
        return endSeason;
    }
    public void setEndSeason(Integer endSeason) {
        this.endSeason = endSeason;
    }

    public Integer getTypeId() {
        return this.typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
