package unit.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.CategoryDaoMemory;

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
    @Test
    @DisplayName("Return null for negative id")
    public void notAcceptIdNegative(){
        CategoryEntity actualCategory = categoryDao.findByIdCategory(-3);
        assertNull(actualCategory);
    }
    @Test
    @DisplayName("Return null for other id")
    public void notAcceptOtherId(){
        CategoryEntity actualCategory = categoryDao.findByIdCategory(6);
        assertNull(actualCategory);
    }
}
