package com.udemySpringExample1.udemySpringExample1.recipieApp.Controller;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Categories;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.CategoryRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.UnitOfMeasureRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Service.RecipieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final RecipieService recipieService;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, RecipieService recipieService) {
        this.categoryRepository = categoryRepository;
        this.recipieService = recipieService;
    }

    @RequestMapping("/index")
    public String getIndexPage(Model model){
        Optional<Categories> categoryRepositories = categoryRepository.findByCategoryName("Indian");
        System.out.println("Total Indian Category is: " + categoryRepositories.isPresent());
        model.addAttribute("recipies" , recipieService.getRecipies());
        return "recipie-app/index";
    }

    @RequestMapping("/recipie/show/{id}")
    public String getRecipieById( Model model, @PathVariable String id){
        Long recipieId = Long.valueOf(id);
        model.addAttribute("recipie", recipieService.getRecipieById(recipieId));
        return "recipie-app/show-recipe";
    }

    @RequestMapping("/addRecipe")
    public String getRecipeForm(Model model){
        model.addAttribute("recipeForm", new RecipiesDO());
        return "recipie-app/save-recipe";
    }

    @PostMapping("/saveRecipie")
    public String saveOrUpdateRecipie(@ModelAttribute RecipiesDO recipiesDO){
        RecipiesDO savedDO = recipieService.saveRecipie(recipiesDO);
        return "redirect:/recipie/show/" + savedDO.getRecipieId();
    }
}

