package unit.domain.service;


import com.fpmislata.NutriFusionFood.common.exceptions.BusinessException;
import com.fpmislata.NutriFusionFood.domain.entity.*;
import com.fpmislata.NutriFusionFood.domain.service.impl.RecipeServiceImpl;
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

import static data.RecipeData.recipeList;
import static org.junit.jupiter.api.Assertions.*;
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
            when(recipeRepositoryMock.findAllRecipe()).thenReturn(recipeList);
            assertEquals(recipeList, recipeService.findAllRecipe());
        }
    }

    @Nested
    class FindById {
        @Test
        @DisplayName("when id not in list , Service throw exception")
        void throwExceptionWrongId() {
            when(recipeRepositoryMock.findByIdRecipe(-2)).thenReturn(null);
            assertThrows(BusinessException.class,()->recipeService.findByIdRecipe(-2));
        }

        @Test
        @DisplayName("when id in list, service return only that recipe")
        void returnRecipeById() {
            when(recipeRepositoryMock.findByIdRecipe(2)).thenReturn(recipeList.get(1));
            assertEquals(recipeList.get(1), recipeService.findByIdRecipe(2));
        }
    }

    @Nested
    class Delete {
        @Test
        @DisplayName("delete recipe by id")
        void deleteRecipeById() {
            when(recipeRepositoryMock.findByIdRecipe(1)).thenReturn(recipeList.get(0));
            recipeService.delete(recipeList.get(0).getId());
            verify(recipeRepositoryMock).delete(recipeList.get(0).getId());
        }
        @Test
        @DisplayName("when id not in list , Service throw exception")
        void throwExceptionWrongId() {
            assertThrows(BusinessException.class,()->recipeService.delete(-2));
        }
        @Test
        @DisplayName("when different user from profile, Service throw exception")
        void throwExceptionWrongUser() {
            assertThrows(BusinessException.class,()->recipeService.delete(3));
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
        //añadir test para la excepcion
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
                    recipeList.get(0),
                    recipeList.get(1),
                    recipeList.get(2)));
            assertEquals(List.of(recipeList.get(0),
                    recipeList.get(1),
                    recipeList.get(2)), recipeService.findByCategory(1));
        }
    }
}
