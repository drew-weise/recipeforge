USE recipeforge_test;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE recipe_ingredients;
TRUNCATE TABLE ingredients;
TRUNCATE TABLE recipes;
TRUNCATE TABLE users;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO users (id, username, email, password_hash)
VALUES
    (1, 'drew', 'drew@example.com', 'test-password-hash-1'),
    (2, 'alex', 'alex@example.com', 'test-password-hash-2');

INSERT INTO recipes (id, user_id, title, description, instructions, servings)
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

INSERT INTO ingredients (id, name)
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

INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount, preparation)
VALUES
    (1, 1, '2 cups', NULL),
    (1, 2, '2', NULL),
    (1, 3, '1 1/2 cups', NULL),
    (1, 4, '2 tablespoons', 'Melted'),

    (2, 5, '8 ounces', NULL),
    (2, 6, '3 cloves', 'Minced'),
    (2, 7, '2 tablespoons', NULL),

    (3, 8, '3', 'Chopped'),
    (3, 9, '2', 'Diced'),
    (3, 10, '6 cups', NULL);