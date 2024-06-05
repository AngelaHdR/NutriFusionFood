package integration;

import com.fpmislata.NutriFusionFood.common.exceptions.BusinessException;
import com.fpmislata.NutriFusionFood.domain.entity.*;
import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import com.fpmislata.NutriFusionFood.domain.service.impl.RecipeServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.*;
import com.fpmislata.NutriFusionFood.persistance.repository.impl.RecipeRepositoryImpl;
import data.RecipeData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplRepositoryTest {
    private final RecipeDao recipeDao = Mockito.mock(RecipeDao.class);
    private final RecipeService recipeService =
            new RecipeServiceImpl(new RecipeRepositoryImpl(recipeDao));
    public final List<RecipeEntity> recipeEntityList = new ArrayList<>(RecipeData.recipeEntityList);
    public final List<Recipe> recipeList = new ArrayList<>(RecipeData.recipeList);

    @Nested
    class FindAll {
        @Test
        @DisplayName("when repository return empty list, Service return empty list")
        void returnEmptyList() {
            when(recipeDao.findAllRecipe()).thenReturn(new ArrayList<>());
            assertEquals(0, recipeService.findAllRecipe().size());
        }

       /* @Test
        @DisplayName("when repository return recipes, service return all recipe")
        void returnAllRecipe() {
            when(recipeDao.findAllRecipe()).thenReturn(recipeEntityList);
            assertEquals(recipeList, recipeService.findAllRecipe());
        }*/
    }

    @Nested
    class FindById {
        @Test
        @DisplayName("when id not in list , Service throw exception")
        void throwExceptionWrongId() {
            when(recipeDao.findByIdRecipe(-1)).thenReturn(null);
            assertThrows(BusinessException.class,()->recipeService.findByIdRecipe(-2));
        }

        /*@Test
        @DisplayName("when id in list, service return only that recipe")
        void returnRecipeById() {
            when(recipeDao.findByIdRecipe(2)).thenReturn(recipeEntityList.get(1));
            assertEquals(recipeList.get(1), recipeService.findByIdRecipe(2));
        }*/
    }

    @Nested
    class Delete {
        @Test
        @DisplayName("if id not in list , Service throw exception")
        void throwExceptionWrongId() {
            assertThrows(BusinessException.class,()->recipeService.delete(-2));
        }
        /*@Test
        @DisplayName("delete recipe by id")
        void deleteRecipeById() {
            int recipeId = recipeEntityList.get(0).getId();
            when(recipeDao.findByIdRecipe(1)).thenReturn(recipeEntityList.get(0));
            recipeService.delete(recipeId);
            verify(recipeDao).delete(recipeId);
        }*/
    }

    @Nested
    class Insert {

        @Test
        @DisplayName("Insert new recipe")
        void insertNewRecipe() {
            Recipe recipe3 = new Recipe(3, "Ramen", "es", "x", "Paso 1...", 240,
                    new ArrayList<>(List.of(new Ingredient(2, false, false, "fideos chinos", 1, 12))),
                    new ArrayList<>(List.of(new Tool(2, "cazo"))),
                    new User(1, "Jose", "Perez", "Garcia", "1989-08-18", true, "p1", "mail1", "jose"),
                    new Category(1, "salado"), new HashMap<>());
            RecipeEntity recipeEntity3 = new RecipeEntity(3, "Ramen", "es", "x", "Paso 1...", 240,new UserEntity(1, "Jose", "Perez", "Garcia", "1989-08-18", true, "p1", "mail1", "jose"),
                    new CategoryEntity(1, "salado"));
            recipeService.insert(recipe3);
            verify(recipeDao).insert(recipeEntity3,new ArrayList<>(List.of(new IngredientEntity(2, false, false, "fideos chinos", 1, 12)))
                    ,new ArrayList<>(List.of(new ToolEntity(2, "cazo"))));
        }
    }

    @Nested
    class RecipeFindByCategory {
        @ParameterizedTest
        @ValueSource(ints = {0, 8, -28})
        @DisplayName("when id not in list , Service return empty list")
        void returnEmptyList(int id) {
            when(recipeDao.findByCategory(id)).thenReturn(new ArrayList<>());
            assertEquals(new ArrayList<>(), recipeService.findByCategory(id));
        }

        /*@Test
        @DisplayName("given one category id, service return all recipe from one  category")
        void returnAllRecipe() {
            when(recipeDao.findByCategory(1)).thenReturn(List.of(
                    recipeEntityList.get(0),
                    recipeEntityList.get(1),
                    recipeEntityList.get(2)));
            assertEquals(List.of(RecipeData.recipeList.get(0),
                    recipeList.get(1),
                    recipeList.get(2)), recipeService.findByCategory(1));
        }*/
    }
}

