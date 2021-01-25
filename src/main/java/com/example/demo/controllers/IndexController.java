package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Category;
import com.example.demo.domain.UnitOfMeasure;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.UnitOfMeasureRepository;
import com.example.demo.services.RecipeService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class IndexController {

	private final RecipeService recipeService;
	
	public IndexController( RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	/*
	private UnitOfMeasureRepository unitOfMeasureRepository;
	private CategoryRepository categoryRepository;
	
	
	public IndexController(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
		super();
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.categoryRepository = categoryRepository;
	}
*/

	@RequestMapping( {"", "/" , "/index" })
	public String getIndexPage( Model model) {
		
		
		//log.debug("In IndexController");
		model.addAttribute( "recipes", recipeService.getRecipes() );
		
		/*
		Optional< Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional< UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		System.out.println( "cat id : " + categoryOptional.get().getId() );
		System.out.println( "uom id : " + unitOfMeasureOptional.get().getId() );
		*/
		return "index";
	}
}
