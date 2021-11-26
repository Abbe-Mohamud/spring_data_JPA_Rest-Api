package se.lexicon.spring_data_jpa_restapi.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;


    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_category",
               joinColumns = @JoinColumn(name = "recipe_id"),
                inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private List<RecipeCategory> categories;

    public Recipe() {}

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }



    public void addRecipeCategory(RecipeCategory recipeCategory){
        categories.add(recipeCategory);
        recipeCategory.getRecipes().add(this);
    }
    public void removeRecipeCategory(RecipeCategory recipeCategory){
        recipeCategory.getRecipes().remove(this);
        recipeIngredients.remove(recipeCategory);

    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
       if (recipeIngredients == null) {
            recipeIngredients = new ArrayList<>();
        }
       this.recipeIngredients.add(recipeIngredient);
        recipeIngredient.setRecipe(this);
    }


    public void removeRecipeCategory(RecipeIngredient recipeIngredient){
        recipeIngredient.setRecipe(null);
        recipeIngredients.remove(recipeIngredient);

    }


    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getRecipeName(), recipe.getRecipeName()) && Objects.equals(getRecipeIngredients(), recipe.getRecipeIngredients()) && Objects.equals(getInstruction(), recipe.getInstruction()) && Objects.equals(getCategories(), recipe.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeName(), getRecipeIngredients(), getInstruction(), getCategories());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", instruction=" + instruction +
                ", categories=" + categories +
                '}';
    }
}
