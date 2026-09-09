# RecipeForge

RecipeForge is an enterprise Java web application for generating, editing, saving, and organizing personalized recipes.

Users will be able to describe the type of recipe they want, receive a structured recipe generated through an external AI service, and save recipes to a personal library. The initial project scope focuses exclusively on recipe generation and management.

## Problem Statement

Finding a recipe that matches a particular craving, dietary preference, skill level, or occasion can require searching through numerous websites. RecipeForge will simplify this process by allowing users to describe what they want and receive a personalized recipe that can be edited and saved for future use.

## Minimum Viable Product

The planned MVP will allow users to:

- Register and sign in through a third-party identity provider
- Submit an idea for a recipe
- Generate a structured recipe through an external API consumed by Java
- Save generated recipes
- Browse and view saved recipes
- Edit existing recipes
- Delete recipes
- Store ingredients and instructions as structured recipe data
- Use the application through a responsive web interface

## Planned Technologies

- Java
- Maven
- Jakarta Servlets
- JSP
- Apache Tomcat
- JPA and Hibernate
- PostgreSQL
- Log4j2
- JUnit
- Third-party authentication
- External AI API
- HTML and CSS
- AWS deployment

## Planned Data Model

The application will include entities such as:

- User
- Recipe
- Ingredient
- Recipe ingredient
- Instruction
- Category or collection

The database will include multiple one-to-many relationships. For example, one user may save multiple recipes, and one recipe may contain multiple instructions and recipe ingredients.

## Project Structure

```text
recipeforge/
├── pom.xml
└── src/
    └── main/
        ├── java/
        ├── resources/
        └── webapp/
            ├── index.jsp
            └── WEB-INF/
                └── web.xml
```

## Running the Project

Detailed installation and configuration instructions will be added as development progresses.

The application is built with Maven and deployed through Apache Tomcat.

```bash
mvn clean package
```

The generated WAR file will be located in the `target` directory.

## Project Documentation

Project planning materials will include:

- Problem statement
- User stories
- MVP identification
- Project schedule
- Screen designs
- Application flow
- Weekly reflection statements
- Design and code review notes
- Architecture documentation

## Project Status

RecipeForge is currently in the initial planning and project-setup stage.

## Author

Drew Weise
