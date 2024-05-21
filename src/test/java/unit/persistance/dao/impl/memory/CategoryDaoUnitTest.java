package unit.persistance.dao.impl.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import data.CategoryData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.CategoryDaoMemory;

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
            expectedCategoryList = CategoryData.categoryEntityList_es;
        } else if (lang.equals("en")) {
            expectedCategoryList = CategoryData.categoryEntityList_en;
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
            expectedCategory = CategoryData.categoryEntityList_es.get(0);
        } else if (lang.equals("en")) {
            expectedCategory = CategoryData.categoryEntityList_en.get(0);
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
