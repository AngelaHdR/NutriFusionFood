package data;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;

import java.util.List;

public class CategoryData {
    public static final List<CategoryEntity> categoryEntityList_es = List.of(
            new CategoryEntity(1,"salado"),
            new CategoryEntity(2,"postre"),
            new CategoryEntity(3,"bebida"),
            new CategoryEntity(4,"snack")
    );
    public static final List<CategoryEntity> categoryEntityList_en = List.of(
            new CategoryEntity(1,"main dish"),
            new CategoryEntity(2,"dessert"),
            new CategoryEntity(3,"drink"),
            new CategoryEntity(4,"snack")
    );
    public static final List<Category> categoryList_es = List.of(
            new Category(1,"salado"),
            new Category(2,"postre"),
            new Category(3,"bebida"),
            new Category(4,"snack")
    );
    public static final List<Category> categoryList_en = List.of(
            new Category(1,"main dish"),
            new Category(2,"dessert"),
            new Category(3,"drink"),
            new Category(4,"snack")
    );
}
