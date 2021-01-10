package com.vivek.priority.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vivek.priority.exception.AuthenticationNotValidException;
import com.vivek.priority.model.Areas;
import com.vivek.priority.repository.AreaRepo;

@Service
public class ProcessAreas {

	
	@Autowired
	AreaRepo ar;
	
	@Value("${authentication-key}")
	private String key;
	
	@Value("${areas}")
	private List<String> areas;
	
	@Value("${properties}")
	private List<String> properties; 
	
	/**
	 * Automatic population of DB with default areas and property.
	 * Takes values from application.properties.
	 * */
	@PostConstruct
	private void addAreaAndProperty() {
		List<Areas> arList=ar.findAll();
		Areas ar;
		if(arList.size()>0) {
			ar=arList.get(0);
		}
		else {
			ar=new Areas();
		}
		areas.stream().forEach(x->{
			if(!ar.getAreas().contains(x))ar.getAreas().add(x);
		});
		properties.stream().forEach(x->{
			if(!ar.getProperties().contains(x))ar.getProperties().add(x);
		});
		
		this.ar.save(ar);
	}
	
	
	
	public List<String> getAllAreas(){
		List<Areas> areasList=ar.findAll();
		return areasList.size()>0?areasList.get(0).getAreas().stream().collect(Collectors.toList()):new ArrayList<String>();
	
	}
	
	/**adds new area to db.*/
	public Areas addNewArea(String area, String authKey) {
		if(!authKey.equals(key)) {throw new AuthenticationNotValidException("auth key is invalid");}
		
		Areas newArea;
		List<Areas> currAreas=ar.findAll();
		if(currAreas.size()==0)newArea=new Areas();
		else newArea=currAreas.get(0);
		
		if(!newArea.getAreas().contains(area)){
			newArea.getAreas().add(area);
			ar.save(newArea);
		}
		return newArea;
	}
	
	/**adds new property to db.*/
	public Areas addNewProperty(String property,String authKey) {
		if(!authKey.equals(key)) {throw new AuthenticationNotValidException("auth key is invalid");}
		
		Areas newArea;
		List<Areas> currAreas=ar.findAll();
		if(currAreas.size()==0)newArea=new Areas();
		else newArea=currAreas.get(0);
		
		if(!newArea.getProperties().contains(property)) {
			newArea.getProperties().add(property);
			ar.save(newArea);
		}
		return newArea;
		
	}
	
}
