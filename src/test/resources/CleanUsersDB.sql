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

INSERT INTO users (user_id, display_name, email, password_hash)
VALUES
    (1, 'drew123', 'drew@example.com', 'test-password-hash-1'),
    (2, 'alex456', 'alex@example.com', 'test-password-hash-2');