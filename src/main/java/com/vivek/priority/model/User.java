package com.vivek.priority.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	private String _id;
	
	private String name;
	
	/**
	 * This field has been specially designed s.t. it will provide automatic addition & deletion of areas
	 * and properties. 
	 * < {AREA : {Property1:value, Property2:Value}}
	 * Example, for user with  name vivek, {RelationShips: {priority:1, satisfaction:Very_High}}
	 * */
	private Map<String,Map<String,String>> areas;
	
	public User() {
		areas=new HashMap<String,Map<String,String>>();
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String,Map<String,String>> getAreas() {
		return areas;
	}
	public void setAreas(Map<String,Map<String,String>> areas) {
		this.areas = areas;
	}
	
}
