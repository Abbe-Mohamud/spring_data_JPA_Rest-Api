package se.lexicon.spring_data_jpa_restapi.model.forms;

import se.lexicon.spring_data_jpa_restapi.model.entity.Ingredient;
import se.lexicon.spring_data_jpa_restapi.model.entity.Measurement;
import se.lexicon.spring_data_jpa_restapi.model.entity.Recipe;

public class RecipeIngredientFormDto {

    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    private Recipe recipe;

    public RecipeIngredientFormDto() {
    }

    public RecipeIngredientFormDto(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredientFormDto(Ingredient ingredient, double amount, Measurement measurement) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
