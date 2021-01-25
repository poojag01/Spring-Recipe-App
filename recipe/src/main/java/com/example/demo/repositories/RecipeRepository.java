package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Category;
import com.example.demo.domain.Recipe;

public interface RecipeRepository  extends CrudRepository< Recipe, Long>{

	//void saveAll(List<Recipe> recipes);
	
	//Optional< Recipe> findByDescription( String description);

}
