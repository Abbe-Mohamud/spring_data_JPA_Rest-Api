package se.lexicon.spring_data_jpa_restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.spring_data_jpa_restapi.model.dto.RecipeDto;
import se.lexicon.spring_data_jpa_restapi.model.forms.RecipeFormDto;
import se.lexicon.spring_data_jpa_restapi.service.RecipeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
public class RecipeControllerImpl implements RecipeController{


    private  final RecipeService recipeService;

    @Autowired
    public RecipeControllerImpl(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    @PostMapping(path ="/api/recipes")
    public ResponseEntity<RecipeDto> create(@RequestBody RecipeFormDto form) {
        RecipeDto recipeDto = recipeService.create(form);
        return ResponseEntity
                .status(HttpStatus.CREATED).body(recipeDto);
    }

    @Override
    public ResponseEntity<Collection<RecipeDto>> find(String search, String[] values) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> findById(@PathVariable("id") Integer id) {

        RecipeDto recipeDto = recipeService.findById(id);
        return ResponseEntity.ok(recipeDto);

    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<RecipeDto>> findAll() {
        List<RecipeDto> foundRecipes = recipeService.findAll();
//        Collection<RecipeDto> allFoundRecipes = new ArrayList<>();

        return ResponseEntity.ok(foundRecipes);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<RecipeDto> update(@PathVariable("id") Integer id, @RequestBody RecipeFormDto form) {
        RecipeDto recipeDto = recipeService.update(id, form);
        return ResponseEntity.ok(recipeDto);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        boolean wasDeleted = recipeService.delete(id);
        return ResponseEntity.ok(wasDeleted ? "Recipe with id " +  id + " was deleted" : "Recipe with id " + id + " was not deleted");
    }
}
