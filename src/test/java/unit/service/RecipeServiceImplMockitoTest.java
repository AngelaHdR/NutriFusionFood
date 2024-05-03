package unit.service;


import com.fpmislata.NutriFusionFood.domain.entity.*;
import com.fpmislata.NutriFusionFood.domain.service.impl.RecipeServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
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
    private final Recipe recipe1 = new Recipe(2, "Salmorejo", "es", "x", 60, "Paso 1...",
            new ArrayList<>(List.of(new Ingredient(1, true, false, "pan", "bread", 1, 12))),
            new ArrayList<>(List.of(new Tool(1, "batidora", "blender"))),
            new User(1, "Jose", "Perez", "Garcia", "1989-08-18", true, "p1", "mail1", "jose"),
            new Category(1, "salado", "main dish"), new HashMap<>());
    private final Recipe recipe2 = new Recipe(4, "Torrijas", "es", "x", "Paso 1...", 45);
    private final List<Recipe> recipeList = List.of(recipe1, recipe2);

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
        @DisplayName("when id not in list , Service return null")
        void returnEmptyList() {
            when(recipeRepositoryMock.findByIdRecipe(-1)).thenReturn(null);
            assertEquals(null, recipeService.findByIdRecipe(-1));
        }

        @Test
        @DisplayName("when id in list, service return only that recipe")
        void returnRecipeById() {
            when(recipeRepositoryMock.findByIdRecipe(2)).thenReturn(recipe1);
            assertEquals(recipe1, recipeService.findByIdRecipe(2));
        }
    }

    @Nested
    class Delete {
        @Test
        @DisplayName("delete recipe by id")
        void deleteRecipeById() {
            recipeService.delete(recipe2.getId());
            verify(recipeRepositoryMock).delete(recipe2.getId());

        }
    }

    @Nested
    class Insert {

        @Test
        @DisplayName("Insert new recipe")
        void insertNewRecipe() {
            Recipe recipe3 = new Recipe(3, "Ramen", "es", "x", 240, "Paso 1...",
                    new ArrayList<>(List.of(new Ingredient(2, false, false, "fideos chinos", "chinesse ramen", 1, 12))),
                    new ArrayList<>(List.of(new Tool(2, "cazo", "pot"))),
                    new User(1, "Jose", "Perez", "Garcia", "1989-08-18", true, "p1", "mail1", "jose"),
                    new Category(1, "salado", "main dish"), new HashMap<>());
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
            when(recipeRepositoryMock.findByCategory(1)).thenReturn(List.of(recipe1));
            assertEquals(List.of(recipe1), recipeService.findByCategory(1));
        }
    }
}
