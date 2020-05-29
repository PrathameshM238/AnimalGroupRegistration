package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.AnimalGroup;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AnimalGroupBMTest {
	@Autowired
	AnimalGroupBM agBm; 
	@Test
	public void testGetAnimalGroupByNumber(){
		AnimalGroup ag=agBm.getAnimalGroupByNumber("034218");
		assertEquals("03421823",ag.getAnimalGroupNumber());
	}

}
