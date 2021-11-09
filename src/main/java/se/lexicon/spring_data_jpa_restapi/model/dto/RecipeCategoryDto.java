package se.lexicon.spring_data_jpa_restapi.model.dto;

public class RecipeCategoryDto {

    private int categoryId;
    private String category;

    public RecipeCategoryDto() {
    }

    public RecipeCategoryDto(int categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
