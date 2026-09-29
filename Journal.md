# Weekly Reflection

Weekly Reflections for RecipeForge

## Week 1 


    


## Week 2

#### 9/1/1 - 3.0 Hours

**Tasks Completed:**


Choose project
- Create repository
- Began listing technologies that I plan to use for this projet
- Write problem statement

## Week 3

Gone on Vacation no work completed


## Week 4

#### 9/22/26–9/29/26 Time spent specifically on the project is unknown, probably around 12 Hours 

**Tasks Completed:**

- Updated `pom.xml` with dependencies for JUnit and Log4j2.
- Confirmed that the project builds with the new dependencies.
- Added the `DesignDocuments` folder and `Journal.md` to the project.
- Expanded the RecipeForge problem statement.
- Created and organized the MVP and Non-MVP user stories.
- Moved saved recipe preferences to the Non-MVP scope.
- Created wireframes for signing in, viewing saved recipes, generating a recipe, manually adding or editing a recipe, viewing a recipe, and managing recipe generation preferences.
- Updated the Forge Recipe wireframe to use a chat-style interface.
- Added multiple recipe suggestions to the recipe generation process.
- Added the wireframes to the screen design documentation.
- Updated the project plan based on the wireframes, user stories, and required course checkpoints.
- Created the `recipeforge` and `recipeforge_test` MySQL databases.
- Created tables for users, recipes, ingredients, and recipe ingredients.
- Added primary keys, auto-incrementing IDs, unique constraints, and foreign-key relationships.
- Created reusable SQL scripts for rebuilding the database and loading test data.
- Added separate database and Hibernate configuration files for the regular application and the test environment.
- Configured Hibernate to connect to the MySQL test database.
- Created the `User` Hibernate entity with fields for ID, username, email, and password hash.
- Added JPA annotations to map the `User` class to the `users` table.
- Created and ran DAO tests for inserting, retrieving, updating, deleting, and searching for users.
- Added test setup that resets the test database before each test.
- Fixed a foreign-key problem caused by recipes still referencing users during delete tests.
- Added basic Javadoc comments to the `User` entity.
- Clarified the difference between exact property searches and `LIKE` searches.

**Challenges and Decisions:**

- I originally planned to collect recipe preferences as part of the MVP, but moved the preferences page to the Non-MVP scope to keep the first version of the application manageable.
- I decided that the signed-in homepage should be the My Recipes page.
- I decided to keep My Recipes and Forge Recipe as separate pages.
- I changed the recipe generator from a long form into a chat-style interface so users can clarify their requests without restarting.
- I initially had trouble distinguishing the database model, physical schemas, and EER diagram features in MySQL Workbench.
- I separated the regular application resources from the test resources so tests use `recipeforge_test` instead of the development database.
- I decided to store recipe instructions directly in the recipe record to keep the first database design simple.
- I decided to store ingredients separately from recipes and use a linking table so one ingredient can belong to multiple recipes.
- The user delete test initially failed because recipes referenced the user being deleted. I resolved this by clearing dependent tables before resetting the users table.
- I decided to use Hibernate to map Java entity classes to database tables and handle database operations.
- I kept the initial `User` entity focused on the fields currently needed by RecipeForge instead of adding unnecessary profile fields.

**Next Steps:**

- Finish testing the remaining DAO classes.
- Create the `Recipe`, `Ingredient`, and `RecipeIngredient` entity classes.
- Map the relationships between recipes and ingredients with Hibernate.
- Add DAO tests for recipes and ingredients.
- Begin creating the first controller and JSP for displaying user or recipe data.
- Improve the test data and database reset scripts as additional entities are added.

#### Extra Notes

I decided to use this journal as the main file for tracking both my work and the time I spend on the project. Keeping 
everything in one place feels more organized than maintaining several different tracking files.

    
