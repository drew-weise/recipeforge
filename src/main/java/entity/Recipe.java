package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recipes")
/**
 * Represents a Recipe in RecipeForge.
 *
 * @author dweise
 */
public class Recipe {

    /** The recipe's database recipeId. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int recipeId;

    /** The recipe's recipeTitle. */
    @Column(name = "title", nullable = false)
    private String recipeTitle;

    /** The recipe's recipeDescription. */
    @Column(name = "description")
    private String recipeDescription;

    /** The recipe's recipeInstruction. */
    @Column(name = "instructions")
    private String recipeInstruction;

    /** The recipe's recipeServings. */
    @Column(name = "servings")
    private int recipeServings;

    /** The recipe's user. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /** Required by Hibernate. */
    public Recipe() {
    }

    /**
     * Creates a new Recipe.
     *
     * @param recipeTitle       the recipe title
     * @param recipeDescription the recipe description
     * @param recipeInstruction the recipe instruction
     * @param recipeServings    the recipe servings
     * @param user              the user
     */
    public Recipe(String recipeTitle, String recipeDescription, String recipeInstruction, int recipeServings, User user) {
        this.recipeTitle = recipeTitle;
        this.recipeDescription = recipeDescription;
        this.recipeInstruction = recipeInstruction;
        this.recipeServings = recipeServings;
        this.user = user;
    }

    /** @return the recipe id */
    public int getRecipeId() {return recipeId;}

    /** @return the user */
    public User getUser() {return user;}

    /** Sets the user. */
    public void setUser(User user) {this.user = user;}

    /** @return the recipe title */
    public String getRecipeTitle() {return recipeTitle;}

    /** Sets the recipe title. */
    public void setRecipeTitle(String recipeTitle) {this.recipeTitle = recipeTitle;}

    /** @return the recipe description */
    public String getRecipeDescription() {return recipeDescription;}

    /** Sets the recipe description. */
    public void setRecipeDescription(String recipeDescription) {this.recipeDescription = recipeDescription;}

    /** @return the recipe instruction */
    public String getRecipeInstruction() {return recipeInstruction;}

    /** Sets the recipe instruction. */
    public void setRecipeInstruction(String recipeInstruction) {this.recipeInstruction = recipeInstruction;}

    /** @return the recipe servings */
    public int getRecipeServings() {return recipeServings;}

    /** Sets the recipe servings. */
    public void setRecipeServings(int recipeServings) {this.recipeServings = recipeServings;}

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeTitle='" + recipeTitle + '\'' +
                ", recipeDescription='" + recipeDescription + '\'' +
                ", recipeInstruction='" + recipeInstruction + '\'' +
                ", recipeServings=" + recipeServings +
                '}';
    }
}