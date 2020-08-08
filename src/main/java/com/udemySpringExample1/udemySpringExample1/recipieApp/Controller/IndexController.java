package com.udemySpringExample1.udemySpringExample1.recipieApp.Controller;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Categories;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.CategoryRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.UnitOfMeasureRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Service.RecipieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final RecipieService recipieService;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, RecipieService recipieService, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipieService = recipieService;
    }

    @RequestMapping("/index")
    public String getIndexPage(Model model){
        Optional<Categories> categoryRepositories = categoryRepository.findByCategoryName("Indian");
        System.out.println("Total Indian Category is: " + categoryRepositories.isPresent());
        model.addAttribute("recipies" , recipieService.getRecipies());
        return "recipie-app/index";
    }
}