package se.lexicon.spring_data_jpa_restapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.spring_data_jpa_restapi.model.dto.RecipeDto;
import se.lexicon.spring_data_jpa_restapi.model.forms.RecipeFormDto;

import java.util.Collection;

public interface RecipeController {


    ResponseEntity<RecipeDto> create(RecipeFormDto form);


    ResponseEntity<Collection<RecipeDto>> find(
            @RequestParam(name = "search", defaultValue = "all") String search,
            @RequestParam(name = "values", defaultValue = "all") String[] values);


    ResponseEntity<RecipeDto> findById(@PathVariable("id") Integer id);

    ResponseEntity<Collection<RecipeDto>>  findAll();


    ResponseEntity<RecipeDto> update(Integer id, RecipeFormDto form);


    ResponseEntity<String> delete(Integer id);
}
