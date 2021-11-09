package se.lexicon.spring_data_jpa_restapi.model.dto;



public class IngredientDto {

    private int ingredientId;
    private String ingredientName;


    public IngredientDto() {
    }

    public IngredientDto(int ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
