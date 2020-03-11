package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.AnimalGroupTO;
import com.example.demo.service.AnimalGroupBM;

@RestController
public class AnimalGroupRestService {
	@Autowired
	AnimalGroupBM agBm;
	
	@RequestMapping(value="animal-group-registration", method=RequestMethod.POST)
	public void createAnimalGroup(@RequestBody AnimalGroupTO animalGroupTo) {
		agBm.createAnimalGroup(animalGroupTo);
	}

}
