package com.springtest.springbootrecipe.controller;

import com.springtest.springbootrecipe.model.Category;
import com.springtest.springbootrecipe.model.UnitOfMeasure;
import com.springtest.springbootrecipe.repositories.CategoryRepository;
import com.springtest.springbootrecipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class RecipeController {
    private final UnitOfMeasureRepository  unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;


    public RecipeController(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"recipes","/recipes","/recipes.html"})
    public String showAll(Model model){
        log.debug("RecipeController showAll...");
        //model.addAttribute("recipes", recipeBook.findAll());
        Optional<Category> optionalCategory = categoryRepository.findByDescription("Indian");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByUom("Pinch");
        System.out.println("Category id of Indian is "+ optionalCategory.get().getId());
        System.out.println("Unit of Measure id is "+ optionalUnitOfMeasure.get().getId());
        return "index";
    }
}
