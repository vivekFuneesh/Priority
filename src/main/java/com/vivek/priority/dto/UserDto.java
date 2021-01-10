package com.vivek.priority.dto;

import java.util.Map;

public class UserDto {

	private String name;
	private Map<String,Map<String,String>> areas;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Map<String, String>> getAreas() {
		return areas;
	}
	public void setAreas(Map<String, Map<String, String>> areas) {
		this.areas = areas;
	}
	
	
	
	
	
}
