package se.lexicon.spring_data_jpa_restapi.model.dto;

public class RecipeMiniDto {


    private String recipeName;

    public RecipeMiniDto() {
    }

    public RecipeMiniDto(String recipeName) {

        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
