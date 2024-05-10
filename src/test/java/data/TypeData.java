package data;

import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.util.List;

public class TypeData {
    public static final List<TypeEntity> typeEntityList_es = List.of(
            new TypeEntity(1,"carne"),
            new TypeEntity(2,"pescado"),
            new TypeEntity(3,"lacteo"),
            new TypeEntity(4,"verdura"),
            new TypeEntity(5,"fruta"),
            new TypeEntity(6,"hidrados")
    );
    public static final List<TypeEntity> typeEntityList_en = List.of(
            new TypeEntity(1,"meet"),
            new TypeEntity(2,"fish"),
            new TypeEntity(3,"dairy"),
            new TypeEntity(4,"vegetable"),
            new TypeEntity(5,"fruit"),
            new TypeEntity(6,"carbs")
    );
    public static final List<Type> typeList_es = List.of(
            new Type(1,"carne"),
            new Type(2,"pescado"),
            new Type(3,"lacteo"),
            new Type(4,"verdura"),
            new Type(5,"fruta"),
            new Type(6,"hidrados")
    );
    public static final List<Type> typeList_en = List.of(
            new Type(1,"meet"),
            new Type(2,"fish"),
            new Type(3,"dairy"),
            new Type(4,"vegetable"),
            new Type(5,"fruit"),
            new Type(6,"carbs")
    );
}
