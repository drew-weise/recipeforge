package persistence;

import entity.Recipe;
import entity.User;
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
        database.runSQL("CleanUsersAndRecipesDB.sql");
        recipeDao = new RecipeDao();
    }

    @Test
    void getByIdSuccess() {
        Recipe recipe = recipeDao.getById(1);
        assertNotNull(recipe);
        assertEquals("Pancakes",  recipe.getRecipeTitle());
    }

    @Test
    void updateSuccess() {
        Recipe recipeToUpdate = recipeDao.getById(1);
        recipeToUpdate.setRecipeTitle("Waffles");
        recipeDao.update(recipeToUpdate);

        Recipe  updatedRecipe = recipeDao.getById(1);
        assertEquals("Waffles", updatedRecipe.getRecipeTitle());
    }


    @Test
    void insertSuccess() {
        User user = new UserDao().getById(1);

        Recipe recipe = new Recipe(
                "Avocado Toast",
                "Toast with Avocado Spread and an Egg",
                "Make some toast. Smash an avocado with a little salt and pepper, then spread on toast. Optionally sprinkle some everything bagel seasoning on top. Cook a sunny-side-up egg and place it on top of the avocado spread.",
                2,
                user
        );

        int insertedRecipeId = recipeDao.insert(recipe);

        assertTrue(insertedRecipeId > 0);

        Recipe insertedRecipe = recipeDao.getById(insertedRecipeId);

        assertNotNull(insertedRecipe);
        assertEquals("Avocado Toast", insertedRecipe.getRecipeTitle());
        assertEquals("Toast with Avocado Spread and an Egg", insertedRecipe.getRecipeDescription());
        assertEquals(2, insertedRecipe.getRecipeServings());
        assertNotNull(insertedRecipe.getUser());
        assertEquals(1, insertedRecipe.getUser().getUserId());
    }


    @Test
    void delete() {
        recipeDao.delete(recipeDao.getById(1));
        assertNull(recipeDao.getById(1));
    }

    @Test
    void getAllSuccess() {
        List<Recipe> recipes = recipeDao.getAll();

        assertNotNull(recipes);
        assertEquals(4, recipes.size());
    }

    @Test
    void getByPropertyEqual() {
        List<Recipe> recipes = recipeDao.getByPropertyEqual("recipeTitle", "Pancakes");
        assertEquals(1, recipes.size());
    }

    @Test
    void getByPropertyLike() {
        List<Recipe> recipes = recipeDao.getByPropertyLike("recipeTitle", "pan");

        assertEquals(1, recipes.size());
        assertEquals("Pancakes", recipes.get(0).getRecipeTitle());
    }
}