package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.UnitOfMeasure;


@RunWith( SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository ;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	//@DirtiesContext
	void testFindByDescription() throws Exception{
		//fail("Not yet implemented");
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		assertEquals( "Teaspoon", uomOptional.get().getDescription() );
	}


	@Test
	void testFindByDescriptionCup() throws Exception{
		//fail("Not yet implemented");
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		
		assertEquals( "Cup", uomOptional.get().getDescription() );
	}
}
