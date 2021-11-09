package se.lexicon.spring_data_jpa_restapi.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_data_jpa_restapi.model.entity.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {

}
