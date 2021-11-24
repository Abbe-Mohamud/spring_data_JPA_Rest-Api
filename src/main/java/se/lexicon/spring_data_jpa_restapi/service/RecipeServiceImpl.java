package se.lexicon.spring_data_jpa_restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.spring_data_jpa_assignment.exception.AppResourceNotFoundException;
import se.lexicon.spring_data_jpa_restapi.model.dto.RecipeDto;
import se.lexicon.spring_data_jpa_restapi.model.entity.Recipe;
import se.lexicon.spring_data_jpa_restapi.model.forms.RecipeFormDto;
import se.lexicon.spring_data_jpa_restapi.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RecipeServiceImpl implements RecipeService{



    private final RecipeRepository recipeRepository;
    private final ConversionService convert;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, ConversionService convert) {
        this.recipeRepository = recipeRepository;
        this.convert = convert;
    }


    @Override
    @Transactional
    public RecipeDto create(RecipeFormDto formDto) {
        return convert.toRecipeDto(recipeRepository.save(convert.toRecipe(formDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeDto findById(Integer id) {
        return convert.toRecipeDto(recipeRepository.findById(id).orElseThrow( () -> new AppResourceNotFoundException("Could not find Recipe with id: " + id)));

    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeDto> findAll() {

       Iterable<Recipe> foundRecipes = recipeRepository.findAll();
       List<RecipeDto> allRecipeDto = new ArrayList<>();

       foundRecipes.forEach(recipe -> allRecipeDto.add(convert.toRecipeDto(recipe)));

        return allRecipeDto;
    }


    @Override
    @Transactional
    public RecipeDto update(Integer id, RecipeFormDto updateForm) {
        Optional<Recipe> foundRecipe = recipeRepository.findById(id);

        if (foundRecipe.isPresent()){
            foundRecipe.get().setRecipeName(updateForm.getRecipeName());
            foundRecipe.get().setRecipeIngredients(updateForm.getRecipeIngredients());
            foundRecipe.get().setInstruction(updateForm.getInstruction());
            foundRecipe.get().setCategories(updateForm.getCategories());
        }
        if (foundRecipe.isPresent()){
            return convert.toRecipeDto(foundRecipe.get());
        } else {
            throw new IllegalArgumentException("Could not find By Id");
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        recipeRepository.deleteById(id);
        return !recipeRepository.existsById(id);
    }


}
