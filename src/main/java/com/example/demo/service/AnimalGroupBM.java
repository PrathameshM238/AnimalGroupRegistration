package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SQLServerAnimalGroupDAO;
import com.example.demo.model.AnimalGroup;
import com.example.demo.bean.AnimalGroupTO;

@Service
public class AnimalGroupBM {

@Autowired
private com.example.demo.model.AnimalGroup agModel;	



@Autowired
SQLServerAnimalGroupDAO agDao;

public void createAnimalGroup(AnimalGroupTO animalGroup) {
	agModel.setAnimalGroupNumber(animalGroup.getAnimalGroupNumber());
	agModel.setAddresses(animalGroup.getAddresses());
	agDao.save(agModel);
}

public AnimalGroup getAnimalGroupByNumber(String animalGroupNumber) {
	return agDao.findByAnimalGroupNumber(animalGroupNumber);
}

public AnimalGroup getAnimalGroupById(Integer animalGroupId) {
	return agDao.findByAnimalGroupId(animalGroupId);
}

}
