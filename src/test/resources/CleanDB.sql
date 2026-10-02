USE recipeforge_test;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS recipe_ingredients;
DROP TABLE IF EXISTS recipes;
DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS users;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE users (
                       user_id INT NOT NULL AUTO_INCREMENT,
                       display_name VARCHAR(50) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       PRIMARY KEY (user_id),
                       UNIQUE KEY email (email)
) ENGINE = InnoDB;

CREATE TABLE recipes (
                         recipe_id INT NOT NULL AUTO_INCREMENT,
                         user_id INT NOT NULL,
                         title VARCHAR(255) NOT NULL,
                         description TEXT,
                         instructions TEXT,
                         servings INT,
                         PRIMARY KEY (recipe_id),
                         KEY user_id (user_id),
                         CONSTRAINT recipes_ibfk_1
                             FOREIGN KEY (user_id) REFERENCES users (user_id)
) ENGINE = InnoDB;

CREATE TABLE ingredients (
                             ingredient_id INT NOT NULL AUTO_INCREMENT,
                             name VARCHAR(100) NOT NULL,
                             PRIMARY KEY (ingredient_id),
                             UNIQUE KEY ingredient_name (name)
) ENGINE = InnoDB;

CREATE TABLE recipe_ingredients (
                                    recipe_id INT NOT NULL,
                                    ingredient_id INT NOT NULL,
                                    amount VARCHAR(100),
                                    PRIMARY KEY (recipe_id, ingredient_id),
                                    KEY ingredient_id (ingredient_id),
                                    CONSTRAINT recipe_ingredients_ibfk_1
                                        FOREIGN KEY (recipe_id) REFERENCES recipes (recipe_id)
                                            ON DELETE CASCADE,
                                    CONSTRAINT recipe_ingredients_ibfk_2
                                        FOREIGN KEY (ingredient_id) REFERENCES ingredients (ingredient_id)
) ENGINE = InnoDB;

INSERT INTO users (user_id, display_name, email, password_hash)
VALUES
    (1, 'drew', 'drew@example.com', 'test-password-hash-1'),
    (2, 'alex', 'alex@example.com', 'test-password-hash-2');

INSERT INTO recipes
(recipe_id, user_id, title, description, instructions, servings)
VALUES
    (
        1,
        1,
        'Pancakes',
        'Simple breakfast pancakes',
        'Mix the ingredients. Heat a pan. Cook each pancake until golden brown on both sides.',
        4
    ),
    (
        2,
        1,
        'Garlic Pasta',
        'Quick pasta with garlic and olive oil',
        'Boil the pasta. Cook the garlic in olive oil. Toss the pasta with the garlic and serve.',
        2
    ),
    (
        3,
        2,
        'Vegetable Soup',
        'A basic vegetable soup',
        'Chop the vegetables. Add everything to a pot with broth. Simmer until tender.',
        6
    );

INSERT INTO ingredients (ingredient_id, name)
VALUES
    (1, 'Flour'),
    (2, 'Eggs'),
    (3, 'Milk'),
    (4, 'Butter'),
    (5, 'Pasta'),
    (6, 'Garlic'),
    (7, 'Olive oil'),
    (8, 'Carrots'),
    (9, 'Potatoes'),
    (10, 'Vegetable broth');

INSERT INTO recipe_ingredients
(recipe_id, ingredient_id, amount)
VALUES
    (1, 1, '2 cups'),
    (1, 2, '2'),
    (1, 3, '1 1/2 cups'),
    (1, 4, '2 tablespoons'),
    (2, 5, '8 ounces'),
    (2, 6, '3 cloves'),
    (2, 7, '2 tablespoons'),
    (3, 8, '3'),
    (3, 9, '2'),
    (3, 10, '6 cups');