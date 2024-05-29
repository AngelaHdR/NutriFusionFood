package unit.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.*;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.repository.impl.RecipeRepositoryImpl;
import data.*;
import org.junit.jupiter.api.*;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class
RecipeRepositoryImplMockitoTest {
    @Mock
    private RecipeDao recipeDaoMock;
    @InjectMocks
    private RecipeRepositoryImpl recipeRepository;


    @Nested
    class FindAll {
        @Test
        @DisplayName("when repository return empty list, Service return empty list")
        void returnEmptyList() {
            when(recipeDaoMock.findAllRecipe()).thenReturn(new ArrayList<>());
            assertEquals(0, recipeRepository.findAllRecipe().size());
        }

        @Test
        @DisplayName("when repository return recipes, service return all recipe")
        void returnAllRecipe() {
            when(recipeDaoMock.findAllRecipe()).thenReturn(RecipeData.recipeEntityList);
            assertEquals(recipeList, recipeRepository.findAllRecipe());
        }
    }

    @Nested
    class FindById {
        @ParameterizedTest
        @ValueSource(ints = {0, 8, -28})
        @DisplayName("when id not in list , Service return null")
        void returnEmptyList(int id) {
            when(recipeDaoMock.findByIdRecipe(id)).thenReturn(null);
            assertNull(recipeRepository.findByIdRecipe(id));
        }

        @Test
        @DisplayName("when id in list, service return only that recipe")
        void returnRecipeById() {
            when(recipeDaoMock.findByIdRecipe(2)).thenReturn(RecipeData.recipeEntityList.get(1));
            assertEquals(recipeList.get(1), recipeRepository.findByIdRecipe(2));
        }
    }

    @Nested
    class delete {
        @Test
        @DisplayName("delete recipe by id")
        void deleteRecipeById() {
            recipeRepository.delete(recipeList.get(2).getId());
            verify(recipeDaoMock).delete(recipeList.get(2).getId());

        }
    }

    @Nested
    class insert {

        @Test
        @DisplayName("Insert new recipe")
        void insertNewRecipe() {
            Recipe recipe5 = new Recipe(3, "Ramen", "es", "x","Paso 1...", 240,
                    new ArrayList<>(List.of(new Ingredient(2, false, false, "fideos chinos", 1, 12))),
                    new ArrayList<>(List.of(new Tool(2, "cazo"))),
                    new User(1, "Jose", "Perez", "Garcia", "1989-08-18", true, "p1", "mail1", "jose"),
                    new Category(1, "salado"), new HashMap<>());
            RecipeEntity recipe6 = new RecipeEntity(3, "Ramen", "es", "x", "Paso 1...",240, UserData.userEntityList.get(0), CategoryData.categoryEntityList_es.get(0));
            recipeRepository.insert(recipe5);
            verify(recipeDaoMock).insert(recipe6,new ArrayList<>(),new ArrayList<>());
        }
    }

    @Nested
    class RecipeFindByCategory {
        @ParameterizedTest
        @ValueSource(ints = {0, 8, -28})
        @DisplayName("when id not in list , Service return empty list")
        void returnEmptyList(int id) {
            when(recipeDaoMock.findByCategory(id)).thenReturn(new ArrayList<>());
            assertEquals(new ArrayList<>(), recipeRepository.findByCategory(id));
        }

        @Test
        @DisplayName("given one category id, service return all recipe from one  category")
        void returnAllRecipe() {
            when(recipeDaoMock.findByCategory(1)).thenReturn(List.of(
                    RecipeData.recipeEntityList.get(0),
                    RecipeData.recipeEntityList.get(1),
                    RecipeData.recipeEntityList.get(2)));
            assertEquals(List.of(recipeList.get(0),
                    recipeList.get(1),
                    recipeList.get(2)).size(), recipeRepository.findByCategory(1).size());
        }
    }
}
