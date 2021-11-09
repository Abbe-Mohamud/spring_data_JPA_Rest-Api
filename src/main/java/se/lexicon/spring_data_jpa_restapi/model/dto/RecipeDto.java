package se.lexicon.spring_data_jpa_restapi.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import se.lexicon.spring_data_jpa_restapi.model.entity.RecipeCategory;
import se.lexicon.spring_data_jpa_restapi.model.entity.RecipeIngredient;
import se.lexicon.spring_data_jpa_restapi.model.entity.RecipeInstruction;

import java.util.List;

public class RecipeDto {

    private int recipeId;
    private String recipeName;
    @JsonManagedReference
    private List<RecipeIngredientDto> recipeIngredients;
    private RecipeInstructionDto instruction;
    private List<RecipeCategoryDto> categories;

    public RecipeDto() {
    }

    public RecipeDto(int recipeId, String recipeName, List<RecipeIngredientDto> recipeIngredients, RecipeInstructionDto instruction, List<RecipeCategoryDto> categories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
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

    public List<RecipeIngredientDto> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredientDto> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstructionDto getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstructionDto instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategoryDto> categories) {
        this.categories = categories;
    }


}
