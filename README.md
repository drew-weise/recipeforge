# RecipeForge

RecipeForge is an enterprise Java web application for generating, editing, saving, and organizing personalized recipes.

Users will be able to describe the type of recipe they want, receive a structured recipe generated through an external AI service, and save recipes to a personal library. The initial project scope focuses exclusively on recipe generation and management.

## Problem Statement

Finding a recipe that matches a specific craving, dietary preference, skill level, available ingredients, or occasion can require searching through numerous websites and comparing recipes from several different sources. Many existing recipe websites provide fixed recipes that may not match what a user wants, while generated recipes are often returned as unstructured text that is difficult to edit, organize, or save.

RecipeForge will simplify this process by allowing users to describe the recipe they want and receive a personalized, structured recipe generated through an external AI service. Users will also be able to create recipes manually, edit generated or manually entered recipes, and save them to a personal recipe library. By keeping ingredients, instructions, and other recipe information as structured data, RecipeForge will provide one place where users can generate, manage, and revisit recipes that fit their individual needs.

## Minimum Viable Product

The planned MVP will allow users to:

- Register and sign into an account
- Submit an idea for a recipe
- Generate a structured recipe through an external API consumed by Java
- Save generated recipes
- Browse and view saved recipes
- Edit existing recipes
- Delete recipes
- Store ingredients and instructions as structured recipe data
- Use the application through a responsive web interface
- Add recipes without AI input at all

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
- JUnit for testing
- Log4J logging

## Design & Planning
* [User Stories](DesignDocuments/UserStories.md)
* [Screen Design](DesignDocuments/Screens.md)
* [Project Plan](ProjectPlan.md)
* [Journal](Journal.md)

## Author

Drew Weise
