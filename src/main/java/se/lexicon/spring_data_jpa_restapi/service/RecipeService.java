package se.lexicon.spring_data_jpa_restapi.service;

import se.lexicon.spring_data_jpa_restapi.model.dto.RecipeDto;
import se.lexicon.spring_data_jpa_restapi.model.forms.RecipeFormDto;

import java.util.List;

public interface RecipeService {

    RecipeDto create(RecipeFormDto form);
    RecipeDto findById(Integer id);
    List<RecipeDto> findAll();
    RecipeDto update(Integer id, RecipeFormDto form);
    boolean delete(Integer id);

}
