package persistence;

import Util.SessionFactoryProvider;
import entity.Recipe;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class RecipeDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get recipe by id
     */
    public Recipe getById(int id) {
        Session session = sessionFactory.openSession();
        Recipe recipe = session.get(Recipe.class, id);
        session.close();
        return recipe;
    }

    /**
     * update recipe
     * @param recipe  Recipe to be updated
     */
    public void update(Recipe recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(recipe);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new recipe
     * @param recipe  Recipe to be inserted
     */
    public int insert(Recipe recipe) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(recipe);
        transaction.commit();
        id = recipe.getRecipeId();
        session.close();
        return id;
    }

    /**
     * Delete a recipe
     * @param recipe Recipe to be deleted
     */
    public void delete(Recipe recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(recipe);
        transaction.commit();
        session.close();
    }


    /** Return a list of all recipes
     *
     * @return All recipes
     */
    public List<Recipe> getAll() {
        try (Session session = sessionFactory.openSession()) {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Recipe> query = builder.createQuery(Recipe.class);
            Root<Recipe> root = query.from(Recipe.class);

            query.select(root);

            List<Recipe> recipes =
                    session.createSelectionQuery(query).getResultList();

            logger.debug("The list of recipes {}", recipes);
            return recipes;
        }
    }

    /**
     * Get recipe by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Recipe> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for recipe with {} = {}", propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery(Recipe.class);
        Root<Recipe> root = query.from(Recipe.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Recipe> recipes = session.createSelectionQuery( query ).getResultList();

        session.close();
        return recipes;
    }

    /**
     * Get recipe by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Recipe> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for recipe with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery(Recipe.class);
        Root<Recipe> root = query.from(Recipe.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Recipe> recipes = session.createQuery( query ).getResultList();
        session.close();
        return recipes;
    }

}

