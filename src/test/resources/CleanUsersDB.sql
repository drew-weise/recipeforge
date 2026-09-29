USE recipeforge_test;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE recipe_ingredients;
TRUNCATE TABLE recipes;
TRUNCATE TABLE ingredients;
TRUNCATE TABLE users;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO users (username, email, password_hash)
VALUES
    ('drew123', 'drew@example.com', 'test-password-hash-1'),
    ('alex456', 'alex@example.com', 'test-password-hash-2');