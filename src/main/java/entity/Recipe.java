package entity;

import jakarta.persistence.*;

/**
 * Represents a Recipe in RecipeForge
 */
@Entity
@Table(name = "recipes")
public class Recipe {

    /**  INSTANCE VARIABLES */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int recipeId;
    @Column(name = "title", nullable = false)
    private String recipeTitle;
    @Column(name = "description")
    private String recipeDescription;
    @Column(name = "instructions")
    private String recipeInstruction;
    @Column(name = "servings")
    private int recipeServings;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    /**
     * Instantiates a new Recipe.
     */
    public Recipe() {
    }


    /**
     * Instantiates a new Recipe.
     *
     * @param recipeTitle       the recipe title
     * @param recipeDescription the recipe description
     * @param recipeInstruction the recipe instruction
     * @param recipeServings    the recipe servings
     * @param user              the user
     */
    public Recipe(String recipeTitle, String recipeDescription, String recipeInstruction, String recipeServings, User user) {
        this.recipeId = recipeId;
    }

    /**
     * Gets recipe id.
     *
     * @return the recipe id
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * Gets recipe title.
     *
     * @return the recipe title
     */
    public String getRecipeTitle() {
        return recipeTitle;
    }

    /**
     * Sets recipe title.
     *
     * @param recipeTitle the recipe title
     */
    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    /**
     * Gets recipe description.
     *
     * @return the recipe description
     */
    public String getRecipeDescription() {
        return recipeDescription;
    }

    /**
     * Sets recipe description.
     *
     * @param recipeDescription the recipe description
     */
    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    /**
     * Gets recipe instruction.
     *
     * @return the recipe instruction
     */
    public String getRecipeInstruction() {
        return recipeInstruction;
    }

    /**
     * Sets recipe instruction.
     *
     * @param recipeInstruction the recipe instruction
     */
    public void setRecipeInstruction(String recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    /**
     * Gets recipe servings.
     *
     * @return the recipe servings
     */
    public int getRecipeServings() {
        return recipeServings;
    }

    /**
     * Sets recipe servings.
     *
     * @param recipeServings the recipe servings
     */
    public void setRecipeServings(int recipeServings) {
        this.recipeServings = recipeServings;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId='" + recipeId + '\'' +
                ", recipeTitle='" + recipeTitle + '\'' +
                ", recipeDescription='" + recipeDescription + '\'' +
                ", recipeInstruction='" + recipeInstruction + '\'' +
                ", recipeServings='" + recipeServings + '\'' +
                '}';
    }
}
