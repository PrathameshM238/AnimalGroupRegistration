package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "animal_group")
public class AnimalGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="animalGroupId")
	private Integer animalGroupId;

	@Column(name = "animalGroupNumber")
	private String animalGroupNumber;

	@Column(name = "type")
	private String agType;

	public AnimalGroup() {
		this.agType = "O-FARM";
	}

	@OneToMany(mappedBy = "fk_AnimalGroup")
	private List<TestModel> test;

	//@OneToMany(mappedBy = "animalGroup")
	// @ManyToMany
	// ({@JoinColumn(name="fk_animalGroup_id"),@JoinColumn(name="fk_address_id")})
	/*
	 * @JoinTable( name = "AnimalGroup_Addresses", joinColumns = { @JoinColumn(name
	 * = "fk_animalGroup_id") }, inverseJoinColumns = { @JoinColumn(name =
	 * "fk_address_id") } )
	 */
	@OneToMany(mappedBy = "animalGroup", cascade = CascadeType.ALL)
	//@JsonIgnoreProperties("animalGroup")
	List<Address> addresses;

	

	public Integer getAnimalGroupId() {
		return animalGroupId;
	}

	public void setAnimalGroupId(Integer animalGroupId) {
		this.animalGroupId = animalGroupId;
	}

	public String getAnimalGroupNumber() {
		return animalGroupNumber;
	}

	public void setAnimalGroupNumber(String animalGroupNumber) {
		this.animalGroupNumber = animalGroupNumber;
	}

	public String getAgType() {
		return agType;
	}

	public void setAgType(String agType) {
		this.agType = agType;
	}

	public List<TestModel> getTest() {
		return test;
	}

	public void setTest(List<TestModel> test) {
		this.test = test;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
