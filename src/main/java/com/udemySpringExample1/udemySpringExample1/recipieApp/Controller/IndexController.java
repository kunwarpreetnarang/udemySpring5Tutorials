package com.udemySpringExample1.udemySpringExample1.recipieApp.Controller;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.IngredientsDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.UnitOfMeasureDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Categories;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.CategoryRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Service.RecipieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Api(tags = "Recipe Application Services Controller", value = "Index Controller")
@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final RecipieService recipieService;
    private static final String saveRecipeUrl = "recipie-app/save-recipe";
    private static final Logger LOG = Logger.getLogger(IndexController.class.getName());
    @Autowired
    public IndexController(CategoryRepository categoryRepository, RecipieService recipieService) {
        this.categoryRepository = categoryRepository;
        this.recipieService = recipieService;
    }

    @GetMapping("/index")
    @ApiOperation(value = "Returns home page for application")
    public String getIndexPage(Model model){
        Optional<Categories> categoryRepositories = categoryRepository.findByCategoryName("Indian");
        log.info("Total Indian Category is: " + categoryRepositories.isPresent());
        model.addAttribute("recipies" , recipieService.getRecipies());
        return "recipie-app/index";
    }

    @GetMapping("/recipie/show/{id}")
    @ApiOperation(value = "Returns recipe details for a specific recipe id")
    public String getRecipieById( Model model, @PathVariable String id){
        LOG.info("Searching for recipe: " + id);
        Long recipieId = Long.valueOf(id);
        model.addAttribute("recipie", recipieService.getRecipieById(recipieId));
        return "recipie-app/show-recipe";
    }

    @GetMapping("/addRecipe")
    public String getRecipeForm(Model model){
        model.addAttribute("recipeForm", new RecipiesDO());
        return saveRecipeUrl;
    }

    @PostMapping("/saveRecipie")
    public String saveRecipie(@ApiParam(value = "Recipes DO as request body for saving recipe", name="RecipiesDO", required = true) @Valid @ModelAttribute("recipeForm") RecipiesDO recipiesDO, BindingResult bindingResult, @RequestParam("imagefile") MultipartFile file){
        if(bindingResult.hasErrors()){

            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });

            return saveRecipeUrl;
        }
        RecipiesDO savedDO = recipieService.saveRecipie(recipiesDO);
        savedDO = recipieService.saveRecipeImage(file, savedDO.getRecipieId());
        return "redirect:/recipie/show/" + savedDO.getRecipieId();
    }

    @GetMapping("/recipie/update/{id}")
    public String updateRecipie(@PathVariable String id, Model model){
        model.addAttribute("recipeForm", recipieService.findRecipieDoById(Long.valueOf(id)));
        return saveRecipeUrl;
    }

    @GetMapping("/recipie/delete/{id}")
    public String deleteRecipie(@PathVariable String id, Model model){
        model.addAttribute("recipies", recipieService.deleteRecipies(Long.valueOf(id)));
        return "redirect:/index";
    }

    @GetMapping("/recipie/ingredient/{id}")
    public String getIngredient(@PathVariable String id, Model model){
        model.addAttribute("recipie", recipieService.findRecipieDoById(Long.valueOf(id)));
        return "recipie-app/list-ingredient";
    }

    @GetMapping("/recipie/{recipieId}/show/ingredient/{id}")
    public String viewIngredient(@PathVariable String recipieId, Model model, @PathVariable String id){
        model.addAttribute("ingredient", recipieService.findIngredientById(Long.valueOf(recipieId),Long.valueOf(id)));
        return "recipie-app/show-ingredient";
    }

    @GetMapping("/recipie/{recipieId}/delete/ingredient/{id}")
    public String deleteIngredient(@PathVariable String recipieId, @PathVariable String id){
        recipieService.deleteIngredient(Long.valueOf(recipieId),Long.valueOf(id));
        return "redirect:/recipie/show/" + recipieId;
    }

    @GetMapping("/addIngredient/{recipieId}")
    public String getIngredientForm(Model model, @PathVariable String recipieId){
        IngredientsDO ingredientsDO = new IngredientsDO();
        ingredientsDO.setRecipieId(Long.valueOf(recipieId));
        model.addAttribute("ingredientForm", ingredientsDO);
        ingredientsDO.setUnitOfMeasureDO(new UnitOfMeasureDO());

        model.addAttribute("uomList", recipieService.listAllUOM());

        return "recipie-app/save-ingredient";
    }

    @PostMapping("/saveIngredient/{recipieId}")
    public String saveIngredient(@ApiParam(value = "Take IngredientsDO as request body") @ModelAttribute IngredientsDO ingredientsDO, @PathVariable String recipieId){
        IngredientsDO savedDO = recipieService.saveIngredient(ingredientsDO, Long.valueOf(recipieId));
        return "redirect:/recipie/ingredient/" + savedDO.getRecipieId();
    }

    @GetMapping("/recipie/{recipieId}/update/ingredient/{id}")
    public String updateIngredient(@PathVariable String recipieId, @PathVariable String id, Model model){
        model.addAttribute("ingredientForm", recipieService.findIngredientById(Long.valueOf(recipieId),Long.valueOf(id)));
        model.addAttribute("uomList", recipieService.listAllUOM());

        return "recipie-app/save-ingredient";
    }

    @GetMapping("recipe/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        if (!id.equals("null") || id != null) {
            RecipiesDO recipeCommand = recipieService.findRecipieDoById(Long.valueOf(id));

            if (recipeCommand.getImages() != null) {
                byte[] byteArray = new byte[recipeCommand.getImages().length];
                int i = 0;

                for (Byte wrappedByte : recipeCommand.getImages()) {
                    byteArray[i++] = wrappedByte; //auto unboxing
                }

                response.setContentType("image/jpeg");
                InputStream is = new ByteArrayInputStream(byteArray);
                IOUtils.copy(is, response.getOutputStream());
            }
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception e){
        String notFoundResponse = "404 ERROR NOT FOUND !!";
        log.error("error not found", e);
        return genericExceptionHandler(notFoundResponse, e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleBadRequest(Exception e){
        String badRequestResponse = "400 BAD REQUEST !!";
        log.error("bad request found", e);
        return genericExceptionHandler(badRequestResponse, e);
    }

    public ModelAndView genericExceptionHandler(String response, Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recipie-app/show-error");
        modelAndView.addObject("response", response);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

}

