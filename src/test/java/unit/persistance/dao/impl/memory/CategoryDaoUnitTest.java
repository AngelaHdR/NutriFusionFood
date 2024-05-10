package unit.persistance.dao.impl.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import antiguo.memory.CategoryDaoMemory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CategoryDaoUnitTest {
    CategoryDao categoryDao = new CategoryDaoMemory();
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @DisplayName("Find all the categories in the database")
    @Test
    public void testFindAllCategories() {
        List<CategoryEntity> actualCategoryList = categoryDao.findAllCategory();
        List<CategoryEntity> expectedCategoryList;
        if (lang.equals("es")){
            expectedCategoryList = List.of(
                    new CategoryEntity(1,"salado"),
                    new CategoryEntity(2,"postre"),
                    new CategoryEntity(3,"bebida"),
                    new CategoryEntity(4,"snack")
            );
        } else if (lang.equals("en")) {
            expectedCategoryList = List.of(
                    new CategoryEntity(1,"main dish"),
                    new CategoryEntity(2,"dessert"),
                    new CategoryEntity(3,"drink"),
                    new CategoryEntity(4,"snack")
            );
        }else {
            expectedCategoryList = new ArrayList<>();
        }

        assertEquals(expectedCategoryList, actualCategoryList);
    }

    @DisplayName("Find categories by their id")
    @Test
    public void testFindCategoryById() {
        CategoryEntity actualCategory = categoryDao.findByIdCategory(1);
        CategoryEntity expectedCategory;
        if (lang.equals("es")){
            expectedCategory= new CategoryEntity(1,"salado");
        } else if (lang.equals("en")) {
            expectedCategory= new CategoryEntity(1,"main dish");
        }else {
            expectedCategory = null;
        }
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
