package com.openclassrooms.api.dto;

import java.util.ArrayList;
import java.util.List;

public class CountDTO {

	private int sizechild;
	private int sizeperson;
	private List<PersonCountDTO> person = new ArrayList<PersonCountDTO>();

	public CountDTO() {

	}

	public CountDTO(int sizechild, int sizeperson, List<PersonCountDTO> person) {
		this.sizechild = sizechild;
		this.sizeperson = sizeperson;
		this.person = person;
	}

	public int getSizechild() {
		return sizechild;
	}

	public void setSizechild(int sizechild) {
		this.sizechild = sizechild;
	}

	public int getSizeperson() {
		return sizeperson;
	}

	public void setSizeperson(int sizeperson) {
		this.sizeperson = sizeperson;
	}

	public List<PersonCountDTO> getPerson() {
		return person;
	}

	public void setPerson(List<PersonCountDTO> person) {
		this.person = person;
	}

}
