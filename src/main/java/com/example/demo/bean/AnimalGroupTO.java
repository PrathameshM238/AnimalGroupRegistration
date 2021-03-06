package com.example.demo.bean;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.model.AnimalGroup;
import com.example.demo.model.TestType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Component
public class AnimalGroupTO {
	
	private Integer id;
	private String animalGroupNumber;
	private String type;
	private List<Test> tests;
	private List<Address> addresses;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnimalGroupNumber() {
		return animalGroupNumber;
	}
	public void setAnimalGroupNumber(String animalGroupNumber) {
		this.animalGroupNumber = animalGroupNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public static AnimalGroupTO map(AnimalGroup agModel) {
		AnimalGroupTO agTo = new AnimalGroupTO();
		Test testTo= new Test();
		  agTo.setId(agModel.getAnimalGroupId());
		  agTo.setAnimalGroupNumber(agModel.getAnimalGroupNumber());
		  agTo.setType(agModel.getAgType());
		  agTo.setTests(agModel.getTest().stream().map(t->testTo.map(t)).collect(
		  Collectors.toList())); 
		  agTo.setAddresses(agModel.getAddresses());
		  return agTo;
	}

}
