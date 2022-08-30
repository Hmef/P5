package com.openclassrooms.api.dto;

import java.util.List;


public class FloodDTO {
	
	//private List<String> listStationNumber = new ArrayList<String>();
	private String address;
	private List<HomeFloodDTO> homeFloodDto;

	public FloodDTO() {
		
	}

	public FloodDTO(String address, List<HomeFloodDTO> homeFloodDto) {
		this.address = address;
		this.homeFloodDto = homeFloodDto;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<HomeFloodDTO> getHomeFloodDto() {
		return homeFloodDto;
	}

	public void setHomeFloodDto(List<HomeFloodDTO> homeFloodDto) {
		this.homeFloodDto = homeFloodDto;
	}
	
	

	
	
}
