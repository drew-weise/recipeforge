package persistence;

import entity.Recipe;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("CleanUsersAndRecipesDB.sql");
        userDao = new UserDao();
    }

    @Test
    void getByIdSuccess() {
        User user = userDao.getById(1);
        assertNotNull(user);
        assertEquals("drew123",  user.getDisplayName());
    }

    @Test
    void updateSuccess() {
        User userToUpdate = userDao.getById(1);
        userToUpdate.setDisplayName("John");
        userDao.update(userToUpdate);

        User  updatedUser = userDao.getById(1);
        assertEquals("John", updatedUser.getDisplayName());
    }

    @Test
    void insertSuccess() {
        User user = new User("Johnny123", "Appleseed@gmail.com", "JApple123");
        int insertUserId = userDao.insert(user);
        assertNotEquals(0, insertUserId);
        User InsertedUser = userDao.getById(insertUserId);
        assertEquals("Johnny123", InsertedUser.getDisplayName());
    }

    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));
    }

    @Test
    void deleteWithRecipesSuccess() {

        User userToDelete = userDao.getById(1);
        assertNotNull(userToDelete);

        List<Recipe> recipes = userToDelete.getRecipes();
        assertEquals(2, recipes.size());

        Recipe recipe1 =  recipes.get(0);
        Recipe recipe2 = recipes.get(1);

        userDao.delete(userToDelete);
        assertNull(userDao.getById(1));

        RecipeDao recipeDao = new RecipeDao();
        assertNull(recipeDao.getById(1));
        assertNull(recipeDao.getById(2));
    }


    @Test
    void getAllSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = userDao.getByPropertyEqual("displayName", "drew123");
        assertEquals(1, users.size());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = userDao.getByPropertyLike("displayName", "drew123");

        assertEquals(1, users.size());
        assertEquals("drew123", users.get(0).getDisplayName());
    }
}