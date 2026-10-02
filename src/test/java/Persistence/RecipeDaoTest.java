package Persistence;

import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class RecipeDaoTest {
    RecipeDao recipeDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("CleanRecipesDB.sql");
        recipeDao = new RecipeDao();
    }

    @Test
    void getByIdSuccess() {
        Recipe recipe = recipeDao.getById(1);
        assertNotNull(recipe);
        assertEquals("drew123",  recipe.getRecipeTitle());
    }

//    @Test
//    void updateSuccess() {
//        Recipe recipeToUpdate = recipeDao.getById(1);
//        recipeToUpdate.setDisplayName("John");
//        recipeDao.update(recipeToUpdate);
//
//        Recipe  updatedRecipe = recipeDao.getById(1);
//        assertEquals("John", updatedRecipe.getDisplayName());
//    }
//
//    @Test
//    void insertSuccess() {
//        Recipe recipe = new Recipe("Johnny123", "Appleseed@gmail.com", "JApple123");
//        int insertRecipeId = recipeDao.insert(recipe);
//        assertNotEquals(0, insertRecipeId);
//        Recipe InsertedRecipe = recipeDao.getById(insertRecipeId);
//        assertEquals("Johnny123", InsertedRecipe.getDisplayName());
//    }
//
//    @Test
//    void delete() {
//        recipeDao.delete(recipeDao.getById(1));
//        assertNull(recipeDao.getById(1));
//    }
//
//    @Test
//    void getAll() {
//        List<Recipe> recipes = recipeDao.getAll();
//        assertEquals(2, recipes.size());
//    }
//
//    @Test
//    void getByPropertyEqual() {
//        List<Recipe> recipes = recipeDao.getByPropertyEqual("displayName", "drew123");
//        assertEquals(1, recipes.size());
//    }
//
//    @Test
//    void getByPropertyLike() {
//        List<Recipe> recipes = recipeDao.getByPropertyLike("displayName", "drew123");
//
//        assertEquals(1, recipes.size());
//        assertEquals("drew123", recipes.get(0).getDisplayName());
//    }
}