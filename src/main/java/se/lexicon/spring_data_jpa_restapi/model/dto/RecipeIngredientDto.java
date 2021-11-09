package se.lexicon.spring_data_jpa_restapi.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import se.lexicon.spring_data_jpa_restapi.model.entity.Ingredient;
import se.lexicon.spring_data_jpa_restapi.model.entity.Measurement;
import se.lexicon.spring_data_jpa_restapi.model.entity.Recipe;

public class RecipeIngredientDto {

    private String recipeIngredientId;
    private IngredientDto  ingredient;
    private double amount;
    private Measurement measurement;
    @JsonBackReference
    private RecipeDto recipe;

    public RecipeIngredientDto() {
    }

    public RecipeIngredientDto(String recipeIngredientId, IngredientDto ingredient, double amount, Measurement measurement, RecipeDto recipe) {
        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredientDto(String recipeIngredientId, IngredientDto ingredient, double amount, Measurement measurement) {
        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(String recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public IngredientDto getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDto ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public RecipeDto getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDto recipe) {
        this.recipe = recipe;
    }
}