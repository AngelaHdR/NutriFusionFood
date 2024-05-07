package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class IngredientEntity {
    private Integer id;
    private Boolean gluten;
    private Boolean lactose;
    private String name
    private Integer startSeason;
    private Integer endSeason;
    private Integer typeId;

    //Constructors (void, basic parameters and all parameters)
    public IngredientEntity() {
    }
    public IngredientEntity(Integer id, Boolean gluten, Boolean lactose, String name, Integer startSeason, Integer endSeason) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name = name;
        this.startSeason = startSeason;
        this.endSeason = endSeason;
    }
    public IngredientEntity(Integer id, Boolean gluten, Boolean lactose, String name, Integer startSeason, Integer endSeason, Integer typeId) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name = name;
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IngredientEntity other = (IngredientEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
