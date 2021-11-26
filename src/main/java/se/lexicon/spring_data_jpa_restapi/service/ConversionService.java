package se.lexicon.spring_data_jpa_restapi.service;

import org.springframework.stereotype.Service;
import se.lexicon.spring_data_jpa_restapi.model.dto.*;
import se.lexicon.spring_data_jpa_restapi.model.entity.*;
import se.lexicon.spring_data_jpa_restapi.model.forms.IngredientFormDto;
import se.lexicon.spring_data_jpa_restapi.model.forms.RecipeCategoryFormDto;
import se.lexicon.spring_data_jpa_restapi.model.forms.RecipeFormDto;
import se.lexicon.spring_data_jpa_restapi.model.forms.RecipeIngredientFormDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversionService {

    public IngredientDto toIngredientDto(Ingredient ingredient){
        return new IngredientDto(ingredient.getIngredientId(), ingredient.getIngredientName());

    }

    public Ingredient toIngredient(IngredientFormDto formDto){
        return new Ingredient(formDto.getIngredientName());
    }



    public RecipeCategory toRecipeCategory(RecipeCategoryFormDto formDto){
        return new RecipeCategory(formDto.getCategory(), null);
    }

    public RecipeCategoryDto toRecipeCategoryDto(RecipeCategory category){
        return new RecipeCategoryDto(category.getCategoryId(), category.getCategory());
    }


    public RecipeIngredientDto toRecipeIngredientDto(RecipeIngredient recipeIngredient){
        return new RecipeIngredientDto(recipeIngredient.getRecipeIngredientId(), toIngredientDto(recipeIngredient.getIngredient()), recipeIngredient.getAmount(), recipeIngredient.getMeasurement(), toRecipeDto(recipeIngredient.getRecipe()));
       // return new RecipeIngredientDto(recipeIngredient.getRecipeIngredientId(),recipeIngredient.getIngredient(), recipeIngredient.getAmount(), recipeIngredient.getMeasurement());
    }


    public List<RecipeIngredient> toRecipeIngredient(RecipeIngredientFormDto formDto){
        //return (List<RecipeIngredient>) new RecipeIngredient(formDto.getIngredient(), formDto.getAmount(), formDto.getMeasurement(),null/*null*/);

        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        for (RecipeIngredient reIngredient: formDto.getRecipe().getRecipeIngredients()){
            recipeIngredients.add(new RecipeIngredient(reIngredient.getIngredient(), reIngredient.getAmount(), reIngredient.getMeasurement(),reIngredient.getRecipe()));
            //recipeIngredients.add(new RecipeIngredient(reIngredient.getIngredient(), reIngredient.getAmount(), reIngredient.getMeasurement()));
        }
        return recipeIngredients;

     }



    public Recipe toRecipe(RecipeFormDto formDto){

//       List<RecipeIngredient> recipeIngredients = new ArrayList<>();
//         for (RecipeIngredient reIngredient: formDto.getRecipeIngredients()){
//            recipeIngredients.add(new RecipeIngredient(reIngredient.getIngredient(), reIngredient.getAmount(), reIngredient.getMeasurement(),reIngredient.getRecipe()));
//            //recipeIngredients.add(new RecipeIngredient(reIngredient.getIngredient(), reIngredient.getAmount(), reIngredient.getMeasurement()));




        RecipeIngredient recipeIngredient = new RecipeIngredient();
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();

        for (RecipeIngredient reIngredient: formDto.getRecipeIngredients()){
            Recipe recipe = new Recipe();

            //reIngredient.setRecipe(recipe);
            //recipeIngredients.add(reIngredient);
            recipeIngredients.add(new RecipeIngredient(reIngredient.getIngredient(), reIngredient.getAmount(), reIngredient.getMeasurement(),reIngredient.getRecipe()));
            //recipeIngredients.add(new RecipeIngredient(reIngredient.getIngredient(), reIngredient.getAmount(), reIngredient.getMeasurement()));

            //recipe.addRecipeIngredient(recipeIngredient);

            recipeIngredients.add(reIngredient);
            reIngredient.setRecipe(recipe);
        }






        List<RecipeCategory> categories = new ArrayList<>();
        for (RecipeCategory reCategory: formDto.getCategories()){
            categories.add(new RecipeCategory(reCategory.getCategory(), reCategory.getRecipes()));
        }


        return new Recipe(formDto.getRecipeName(), /*,formDto.getRecipeIngredients()*/recipeIngredients,formDto.getInstruction(),categories);



        //return new Recipe(formDto.getRecipeName(), /*,formDto.getRecipeIngredients()*/recipeIngredients,formDto.getInstruction(),categories);
    }

    public RecipeDto toRecipeDto(Recipe recipe){

        List<RecipeIngredientDto> recipeIngredients = new ArrayList<>();
        for (RecipeIngredient reIngredient: recipe.getRecipeIngredients()){
            recipeIngredients.add(new RecipeIngredientDto(reIngredient.getRecipeIngredientId(), toIngredientDto(reIngredient.getIngredient()), reIngredient.getAmount(), reIngredient.getMeasurement()));

        }

        List<RecipeCategoryDto> categories = new ArrayList<>();
        for (RecipeCategory reCategory: recipe.getCategories()){
            categories.add(new RecipeCategoryDto(reCategory.getCategoryId(),reCategory.getCategory()));
        }


        RecipeInstructionDto recipeInstructionDto = new RecipeInstructionDto();
        if (recipe.getInstruction() != null){
            RecipeInstruction recipeInstruction = recipe.getInstruction();
            recipeInstructionDto =
                    new RecipeInstructionDto(recipeInstruction.getInstructionId(), recipeInstruction.getInstructions());
        }



        return new RecipeDto(recipe.getRecipeId(), recipe.getRecipeName(), recipeIngredients,recipeInstructionDto,categories);
    }





}
