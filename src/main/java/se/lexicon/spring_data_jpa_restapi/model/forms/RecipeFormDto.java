package se.lexicon.spring_data_jpa_restapi.model.forms;

import se.lexicon.spring_data_jpa_restapi.model.entity.RecipeCategory;
import se.lexicon.spring_data_jpa_restapi.model.entity.RecipeIngredient;
import se.lexicon.spring_data_jpa_restapi.model.entity.RecipeInstruction;

import java.util.List;

public class RecipeFormDto {

    private String recipeName;
    private List<RecipeIngredient> recipeIngredients;
    private RecipeInstruction instruction;
    private List<RecipeCategory> categories;

    public RecipeFormDto() {
    }

    public RecipeFormDto(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
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
}
