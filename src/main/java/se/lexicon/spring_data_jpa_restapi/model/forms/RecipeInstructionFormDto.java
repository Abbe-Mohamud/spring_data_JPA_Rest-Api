package se.lexicon.spring_data_jpa_restapi.model.forms;

public class RecipeInstructionFormDto {

    private String instructions;


    public RecipeInstructionFormDto() {
    }

    public RecipeInstructionFormDto(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
