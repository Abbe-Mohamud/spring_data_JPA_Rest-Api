package se.lexicon.spring_data_jpa_restapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.spring_data_jpa_restapi.model.entity.Ingredient;

import java.util.Collection;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {




    Collection<Ingredient> findIngredientByIngredientName(String ingredientName);

    Collection<Ingredient> findIngredientByIngredientNameContaining(String ingredientName);



   @Query("SELECT i FROM Ingredient i where i.ingredientName = :ingredientName")
   Collection<Ingredient> findByIngredientName(@Param("ingredientName")  String ingredientName);

   @Query("select i from Ingredient i where i.ingredientName like %?1%")
   Collection<Ingredient> findByIngredientNameContains(String ingredientName);



}
