package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.AnimalGroupTO;
import com.example.demo.model.AnimalGroup;
import com.example.demo.service.AnimalGroupBM;

@RestController
@RequestMapping("/animalGroup")
public class AnimalGroupRestService {
	@Autowired
	AnimalGroupBM agBm;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void createAnimalGroup(@RequestBody AnimalGroupTO animalGroupTo) {
		agBm.createAnimalGroup(animalGroupTo);
	}
	
	@RequestMapping(value="/{ag-number}", method=RequestMethod.GET)
	public AnimalGroupTO getAgDetails(@PathVariable("ag-number") String agNumber) {
		return AnimalGroupTO.map(agBm.getAnimalGroupByNumber(agNumber));
	}
	
	@RequestMapping(value="get-animal-group-by-id/{animalGroupId}", method=RequestMethod.GET)
	public AnimalGroupTO getAgDetails(@PathVariable("animalGroupId") Integer animalGroupId) {
		return AnimalGroupTO.map(agBm.getAnimalGroupById(animalGroupId));
	}

}
