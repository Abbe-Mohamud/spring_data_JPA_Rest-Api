package se.lexicon.spring_data_jpa_restapi.model.forms;

import javax.validation.constraints.NotBlank;

public class IngredientFormDto {

    @NotBlank(message = "this field is required")
    private String ingredientName;



    public IngredientFormDto() {
    }


    public IngredientFormDto(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
