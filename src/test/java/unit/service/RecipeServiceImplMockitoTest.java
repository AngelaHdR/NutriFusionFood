package unit.service;


import com.fpmislata.NutriFusionFood.domain.entity.*;
import com.fpmislata.NutriFusionFood.domain.service.impl.RecipeServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import data.RecipeData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplMockitoTest {
    @Mock
    private RecipeRepository recipeRepositoryMock;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @Nested
    class FindAll {
        @Test
        @DisplayName("when repository return empty list, Service return empty list")
        void returnEmptyList() {
            when(recipeRepositoryMock.findAllRecipe()).thenReturn(new ArrayList<>());
            assertEquals(0, recipeService.findAllRecipe().size());
        }

        @Test
        @DisplayName("when repository return recipes, service return all recipe")
        void returnAllRecipe() {
            when(recipeRepositoryMock.findAllRecipe()).thenReturn(RecipeData.recipeList);
            assertEquals(RecipeData.recipeList, recipeService.findAllRecipe());
        }
    }

    @Nested
    class FindById {
        /*@Test
        @DisplayName("when id not in list , Service return null")
        void returnEmptyList() {
            //throw new business exception
            when(recipeRepositoryMock.findByIdRecipe(-2)).thenReturn(null);
            assertEquals(null, recipeService.findByIdRecipe(-2));
        }*/

        @Test
        @DisplayName("when id in list, service return only that recipe")
        void returnRecipeById() {
            when(recipeRepositoryMock.findByIdRecipe(2)).thenReturn(RecipeData.recipeList.get(1));
            assertEquals(RecipeData.recipeList.get(1), recipeService.findByIdRecipe(2));
        }
    }

    @Nested
    class Delete {
        @Test
        @DisplayName("delete recipe by id")
        void deleteRecipeById() {
            List<Recipe> recipeList = new ArrayList<>(RecipeData.recipeList);
            recipeService.delete(recipeList.get(0).getId());
            verify(recipeRepositoryMock).delete(recipeList.get(0).getId());
        }
    }

    @Nested
    class Insert {

        @Test
        @DisplayName("Insert new recipe")
        void insertNewRecipe() {
            Recipe recipe3 = new Recipe(3, "Ramen", "es", "x", "Paso 1...",240,
                    new ArrayList<>(List.of(new Ingredient(2, false, false, "fideos chinos", 1, 12))),
                    new ArrayList<>(List.of(new Tool(2, "cazo"))),
                    new User(1, "Jose", "Perez", "Garcia", "1989-08-18", true, "p1", "mail1", "jose"),
                    new Category(1, "salado"), new HashMap<>());
            recipeService.insert(recipe3);
            verify(recipeRepositoryMock).insert(recipe3);
        }
    }

    @Nested
    class RecipeFindByCategory {
        @ParameterizedTest
        @ValueSource(ints = {0, 8, -28})
        @DisplayName("when id not in list , Service return empty list")
        void returnEmptyList(int id) {
            when(recipeRepositoryMock.findByCategory(id)).thenReturn(new ArrayList<>());
            assertEquals(new ArrayList<>(), recipeService.findByCategory(id));
        }

        @Test
        @DisplayName("given one category id, service return all recipe from one  category")
        void returnAllRecipe() {
            when(recipeRepositoryMock.findByCategory(1)).thenReturn(List.of(
                    RecipeData.recipeList.get(0),
                    RecipeData.recipeList.get(1),
                    RecipeData.recipeList.get(2)));
            assertEquals(List.of(RecipeData.recipeList.get(0),
                    RecipeData.recipeList.get(1),
                    RecipeData.recipeList.get(2)), recipeService.findByCategory(1));
        }
    }
}
