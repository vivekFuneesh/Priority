package com.vivek.priority.model;

import java.util.HashSet;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Areas {

	private String _id;
	private HashSet<String> areas;
	private HashSet<String> properties;
	
	public Areas() {
		areas=new HashSet<String>();
		properties=new HashSet<String>();
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public HashSet<String> getAreas() {
		return areas;
	}

	public void setAreas(HashSet<String> areas) {
		this.areas = areas;
	}
	
	public HashSet<String> getProperties() {
		return properties;
	}

	public void setProperties(HashSet<String> properties) {
		this.properties = properties;
	}

	public void addArea(String area) {
		areas.add(area);
	}
	
	public void addProperty(String property) {
		properties.add(property);
	}
}
