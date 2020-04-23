package com.springtest.springbootrecipe.controller;

import com.springtest.springbootrecipe.repository.RecipeBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {
    @Autowired
    private RecipeBook recipeBook;

    @RequestMapping({"recipes","/recipes","/recipes.html"})
    public String showAll(Model model){
        model.addAttribute("recipes", recipeBook.findAll());
        return "recipes";
    }
}
