package se.lexicon.spring_data_jpa_restapi.model.dto;

public class RecipeInstructionDto {

    private String instructionId;
    private String instructions;

    public RecipeInstructionDto() {
    }

    public RecipeInstructionDto(String instructionId, String instructions) {
        this.instructionId = instructionId;
        this.instructions = instructions;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
