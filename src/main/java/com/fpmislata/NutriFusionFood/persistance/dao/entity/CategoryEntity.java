package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class CategoryEntity {
    private Integer id;
    private String name;

    //Constructor (all parameters)
    public CategoryEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryEntity() {
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        /* Funcionalidad no Implementada para Clientes */
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        /* Funcionalidad no Implementada para Clientes */
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
        CategoryEntity other = (CategoryEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
