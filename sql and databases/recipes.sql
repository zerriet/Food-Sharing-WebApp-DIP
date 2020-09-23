CREATING USER TABLE

CREATE TABLE user (
    user_id INT AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    PRIMARY KEY(user_id)
);

ALTER TABLE user AUTO_INCREMENT=20000;

INSERTING INPUTS IN USER TABLE

INSERT INTO user (
    username, email, password, firstname, lastname
)
VALUES ('KKYC', 'abc123@yahoo.com', 'hello', 'Chloe', 'Khoo');

INSERT INTO user (
    username, email, password, firstname, lastname
)
VALUES ('HELLO', 'abc123@yahoo.com', 'hello', 'Chloe', 'Khoo');

CREATING RECIPE TABLE

CREATE TABLE recipe (
    recipe_id INT AUTO_INCREMENT,
    recipe_name VARCHAR(20) NOT NULL,
    recipe_ingredients VARCHAR(20) NOT NULL,
    recipe_directions TEXT(16000) NOT NULL,
    recipe_rating VARCHAR(20) NOT NULL,
    recipe_calories VARCHAR(20) NOT NULL,
    recipe_time_taken INT NOT NULL,
    recipe_Num_of_Ingredients INT NOT NULL,
    recipe_desc VARCHAR(6000) NOT NULL,
    recipe_cooking_skill VARCHAR(20) NOT NULL,
    user_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(recipe_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

ALTER TABLE recipe AUTO_INCREMENT=30000;

INSERTING INPUTS IN RECIPE TABLE

INSERT INTO recipe (
    recipe_name, recipe_ingredients, recipe_directions,
    recipe_rating, recipe_calories, recipe_time_taken, 
    recipe_Num_of_Ingredients, recipe_desc,
    recipe_cooking_skill, user_id)
    VALUES (
        'Pancake', 'chicken, pork', 'hello, this is a text', '1-star',
        '123', '10', '2', 'hello, this is a text', 'beginner', '20000');

INSERT INTO recipe (
    recipe_name, recipe_ingredients, recipe_directions,
    recipe_rating, recipe_calories, recipe_time_taken, 
    recipe_Num_of_Ingredients, recipe_desc,
    recipe_cooking_skill, user_id)
    VALUES (
        'WAFFLE', 'chicken, pork', 'hello, this is a text', '1-star',
        '123', '10', '2', 'hello, this is a text', 'beginner', '20000');

NESTED QUERY

SELECTING RECIPES FROM USER
SELECT recipe.recipe_id
FROM recipe
WHERE recipe.user_id IN (
    SELECT user.user_id
    FROM user
    WHERE user.user_id = 20000
);

SELECT recipe.recipe_id
FROM recipe
WHERE recipe.user_id IN (
    SELECT user.user_id
    FROM user
    WHERE user.user_id = 20001
);

SELECTING USER FROM RECIPE
SELECT user.user_id
FROM user
WHERE user.user_id IN (
    SELECT recipe.user_id
    FROM recipe
    WHERE recipe.recipe_id = 3000
);