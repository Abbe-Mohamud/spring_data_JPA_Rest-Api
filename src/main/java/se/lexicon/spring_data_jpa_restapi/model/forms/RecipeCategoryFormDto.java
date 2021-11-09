package se.lexicon.spring_data_jpa_restapi.model.forms;


import javax.validation.constraints.NotNull;

public class RecipeCategoryFormDto {

    @NotNull(message = "this field is required")
    private String category;


    public RecipeCategoryFormDto() {
    }

    public RecipeCategoryFormDto(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
