package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

	Category category;// = new Category();
	
	
	@BeforeEach
	public void setUp() {
		category = new Category();
		
	}
	
	@Test
	void getId() throws Exception{
		
		Long idValue = 4l;
		category.setId(idValue);
		assertEquals( idValue, category.getId() );
		
		//fail("Not yet implemented");
	}

	@Test
	void getDescription() throws Exception{

		//fail("Not yet implemented");
	}

	

	@Test
	void testGetRecipe() throws Exception{
		
		
		//fail("Not yet implemented");
	}

}





