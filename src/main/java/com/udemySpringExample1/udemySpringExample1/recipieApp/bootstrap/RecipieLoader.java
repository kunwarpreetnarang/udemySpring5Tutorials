package com.udemySpringExample1.udemySpringExample1.recipieApp.bootstrap;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Constants.Difficulty;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.*;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.CategoryRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.RecipieRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipieLoader implements CommandLineRunner {

    private final RecipieRepository recipieRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipieLoader(RecipieRepository recipieRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipieRepository = recipieRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        recipieRepository.saveAll(getRecipies());
    }

    public List<Recipies> getRecipies(){
        List<Recipies> recipes = new ArrayList<>();
        //get UOM's
        Optional<UnitOfMeasure> eachUnit = unitOfMeasureRepository.findByUom("each");

        if(!eachUnit.isPresent()){
            throw new RuntimeException("UOM not found!");
        }

        Optional<UnitOfMeasure> tableUnit = unitOfMeasureRepository.findByUom("tablespoon");

        if(!tableUnit.isPresent()){
            throw new RuntimeException("UOM not found!");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByUom("teaspoon");

        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByUom("dash");

        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByUom("pint");

        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByUom("cup");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUnit.get();
        UnitOfMeasure tableSpoonUom = tableUnit.get();
        UnitOfMeasure teapoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = dashUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();

        //get Categories
        Optional<Categories> americanCategoryOptional = categoryRepository.findByCategoryName("Indian");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Categories> mexicanCategoryOptional = categoryRepository.findByCategoryName("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Categories americanCategory = americanCategoryOptional.get();
        Categories mexicanCategory = mexicanCategoryOptional.get();

        //Yummy Guac
        Recipies guacRecipe = new Recipies();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.Easy);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        Notes guacNotes = new Notes();
        guacNotes.setRecipieNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        guacNotes.setRecipies(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredients("ripe avocados", 2, eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredients("Kosher salt", 5, teapoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredients("fresh lime juice or lemon juice", 2, tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredients("minced red onion or thinly sliced green onion", 2, tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredients("serrano chiles, stems and seeds removed, minced", 2, eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredients("Cilantro", 2, tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredients("freshly grated black pepper", 2, dashUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredients("ripe tomato, seeds and pulp removed, chopped", 5, eachUom, guacRecipe));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);
        guacRecipe.setUrl("abc.com");
        guacRecipe.setSource("baba");
        //add to return list
        recipes.add(guacRecipe);

        //Yummy Tacos
        Recipies tacosRecipe = new Recipies();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.Moderate);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipieNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacoNotes.setRecipies(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);


        tacosRecipe.getIngredients().add(new Ingredients("Ancho Chili Powder", 2, tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("Dried Oregano", 1, teapoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("Dried Cumin", 1, teapoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("Sugar", 1, teapoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("Salt", 1, teapoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("Clove of Garlic, Choppedr", 1, eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("finely grated orange zestr", 1, tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("fresh-squeezed orange juice", 3, tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("Olive Oil", 2, tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("boneless chicken thighs", 4, tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("small corn tortillasr", 8, eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("packed baby arugula", 3, cupsUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("medium ripe avocados, slic", 2, eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredients("radishes, thinly sliced", 4, eachUom, tacosRecipe));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacosRecipe);
        return recipes;
    }
}
