package Persistence;

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
        database.runSQL("CleanDB.sql");
        userDao = new UserDao();
    }

    @Test
    void getByIdSuccess() {
        User user = userDao.getById(1);
        assertNotNull(user);
        assertEquals("Drew",  user.getUsername());
    }

    @Test
    void updateSuccess() {
        User userToUpdate = userDao.getById(1);
        userToUpdate.setUsername("John");
        userDao.update(userToUpdate);

        User  updatedUser = userDao.getById(1);
        assertEquals("John", updatedUser.getUsername());
    }

    @Test
    void insertSuccess() {
        User user = new User("Johnny123", "Appleseed@gmail.com", "JApple123");
        int insertUserId = userDao.insert(user);
        assertNotEquals(0, insertUserId);
        User InsertedUser = userDao.getById(insertUserId);
        assertEquals("Johnny123", InsertedUser.getUsername());
    }

    @Test
    void delete() {
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));
    }

    @Test
    void getAll() {
        List<User> users = userDao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void getByPropertyEqual() {
        List<User> users = userDao.getByPropertyLike("username", "");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        List<User> users = userDao.getByPropertyLike("lastName", "c");
        assertEquals(3, users.size());
    }
}