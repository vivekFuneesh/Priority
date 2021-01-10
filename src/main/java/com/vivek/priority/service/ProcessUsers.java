package com.vivek.priority.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vivek.priority.exception.AreaNotExistsException;
import com.vivek.priority.exception.PropertyNotExistsException;
import com.vivek.priority.exception.PropertyValueFormatException;
import com.vivek.priority.model.Areas;
import com.vivek.priority.model.User;
import com.vivek.priority.repository.AreaRepo;
import com.vivek.priority.repository.UserRepo;

@Service
public class ProcessUsers {

	@Autowired
	UserRepo ur;
	
	@Autowired
	AreaRepo ar;
	
	@Value("${minimum-priority}")
	int minPriority;
	
	@Value("${maximum-priority}")
	int maxPriority;
	
	
	public User fillPropertyAndValueOfAreaForUser(String name, String area, String property, String value) {
		
		validateAreaAndProperty(area,  property,  value);
		
		User storedUser=ur.findByName(name);/**check if user is already present or not using name as  key.*/
		if(storedUser!=null) {
			Map<String,String> properties=storedUser.getAreas().getOrDefault(area,new HashMap<String,String>());
			properties.put(property, value);
			storedUser.getAreas().put(area, properties);
		}
		else {
			storedUser=new User();
			storedUser.setName(name);
			Map<String,String> properties=new HashMap<>();
			properties.put(property, value);
			storedUser.getAreas().put(area, properties);
		}
		return ur.save(storedUser);
	}
	
	private void validateAreaAndProperty(String area, String property, String value) {
		List<Areas> arList=ar.findAll();
		if(arList.size()<1 || !arList.get(0).getAreas().contains(area)) {
			throw new AreaNotExistsException("We are not processing "+area+" area for the time being");
		}
		if(arList.size()<1 || !arList.get(0).getProperties().contains(property)) {
			throw new PropertyNotExistsException("This property \""+property+"\"is not available to give rating for");
		}
		Integer val=Integer.valueOf(-1);
		try {
			val=Integer.valueOf(value);
		}catch(NumberFormatException ex) {throw new PropertyValueFormatException("invalid value "+value+", should be b/w "
						+minPriority+" and "+ maxPriority);}
		
		if(property.equals("priority") && (val<minPriority || val>maxPriority)) {
			throw new PropertyValueFormatException("Value for property \""+property+"\" is out of bounds"+
						"\n max value is "+maxPriority+", min value is "+minPriority);
		}
	}
		
}
