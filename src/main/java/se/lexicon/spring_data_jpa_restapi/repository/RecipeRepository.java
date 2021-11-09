package se.lexicon.spring_data_jpa_restapi.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_data_jpa_restapi.model.entity.Recipe;

import java.util.Collection;

public interface RecipeRepository extends CrudRepository <Recipe, Integer> {


           /*##########        With driven method      #########*/


    // Search for recipes where recipe name contains specified String
    Collection<Recipe> findRecipesByRecipeNameContains (String recipeName);

    // Search for all recipes that contains a specified ingredient name
    Collection<Recipe> findRecipesByRecipeIngredientsIngredientIngredientName (String ingredientName);

    // Search for all recipes that belong to a specific recipe category
    Collection<Recipe> findRecipesByCategoriesCategory(String category);

    // Search for all recipes that match one or more categories

    Collection<Recipe> findRecipesByCategoriesIn(Collection<String> categories);


           /*#########         With JPQL queries        #########*/


//    // Search for recipes where recipe name contains specified String
//    @Query("SELECT r FROM Recipe r WHERE r.recipeName LIkE CONCAT('%', :recipeName, '%')")
//    Collection<Recipe> findRecipesByNameContains (@Param("recipeName") String recipeName);
//
//    // Search for all recipes that contains a specified ingredient name
//    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeIngredients AS rr WHERE rr.ingredient.ingredientName = :ingredientName")
//    Collection<Recipe> findRecipesByIngredientName (@Param("ingredientName")String ingredientName);
//
//    // Search for all recipes that belong to a specific recipe category
//    @Query("SELECT r FROM Recipe r JOIN FETCH r.categories AS rc WHERE rc.category = :category")
//    Collection<Recipe> findRecipesByCategory(@Param("category")  String category);
//
//    // Search for all recipes that match one or more categories
//    @Query("SELECT r FROM Recipe r WHERE r.categories IN (:categories)")
//    Collection<Recipe> findRecipeCategories(@Param("categories")  List<RecipeCategory> categories);





}
