//package se.lexicon.spring_data_jpa_assignment;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import se.lexicon.spring_data_jpa_assignment.model.entity.Ingredient;
//import se.lexicon.spring_data_jpa_assignment.repository.IngredientRepository;
//
//@Component
//public class AcommandLineRunner implements CommandLineRunner {
//
//
//    @Autowired
//    private IngredientRepository ingredientRepository;
//
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Ingredient newIngredient1 = new Ingredient("Tomato");
//        Ingredient newIngredient2 = new Ingredient("Cheese");
//        Ingredient newIngredient3 = new Ingredient("Flour");
//        Ingredient newIngredient4 = new Ingredient("Onion");
//
//        newIngredient1 = ingredientRepository.save(newIngredient1);
//        newIngredient2 = ingredientRepository.save(newIngredient2);
//        newIngredient3 = ingredientRepository.save(newIngredient3);
//        newIngredient4 = ingredientRepository.save(newIngredient4);
//
//
//        System.out.println(ingredientRepository.findIngredientByIngredientName("Cheese"));
//
//    }
//}
