package unit.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.CategoryDaoMemory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CategoryDaoUnitTest {
    CategoryDao categoryDao = new CategoryDaoMemory();

    @DisplayName("Find all the categories in the database")
    @Test
    public void testFindAllCategories() {
        List<CategoryEntity> actualCategoryList = categoryDao.findAllCategory();
        List<CategoryEntity> expectedCategoryList = List.of(
            new CategoryEntity(1,"salado","main dish"),
            new CategoryEntity(2,"postre","dessert"),
            new CategoryEntity(3,"bebida","drink"),
            new CategoryEntity(4,"snack","snack")
        );
        assertEquals(expectedCategoryList, actualCategoryList);
    }

    @DisplayName("Find categories by their id")
    @Test
    public void testFindCategoryById() {
        CategoryEntity actualCategory = categoryDao.findByIdCategory(1);
        CategoryEntity expectedCategory = new CategoryEntity(1,"salado","main dish");
        assertEquals(expectedCategory, actualCategory);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null for negative,zero or wrong id")
    public void returnNullWrongId(int id){
        CategoryEntity actualCategory = categoryDao.findByIdCategory(id);
        assertNull(actualCategory);
    }

}
