package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.example.demo.domain.Recipe;
import com.example.demo.services.RecipeService;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

class IndexControllerTest {

	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		controller = new IndexController( recipeService);
	}
	
	
	@Test
	public void testMockMVC( ) throws Exception {
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup( controller).build();
		
		mockMvc.perform( get( "/") )
		.andExpect( status().isOk() )
		.andExpect( view().name( "index"));
	}

	@Test
	void testGetIndexPage() throws Exception {
		//fail("Not yet implemented");
		

        Recipe recipe = new Recipe();
        recipe.setId( 1L);
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add( new Recipe() );
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);

        ArgumentCaptor< Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass( Set.class);
       
		
		
		String viewName = controller.getIndexPage( model);
		
		 assertEquals( "index", viewName);
	     verify(recipeService, times(1)).getRecipes();
	     verify( model, times(1)).addAttribute( eq("recipes"), argumentCaptor.capture() );
	     
	    Set<Recipe> setInController = argumentCaptor.getValue();
	    assertEquals( 2, setInController.size() );
		
	}

}
