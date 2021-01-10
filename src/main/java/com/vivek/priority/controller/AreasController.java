package com.vivek.priority.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.priority.service.ProcessAreas;

@RestController
public class AreasController {

	@Autowired
	ProcessAreas pa;
	/**
	 * Get a list of all areas being processed.
	 * */
	@GetMapping("/getAreas")
	public List<String> getAreas() {
		return pa.getAllAreas();
	}

	/**
	 * add a new area. authentication is required in form of @RequestParam as authentication-key
	 * */
	@PostMapping("/addArea/{area}")
	public List<String> addNewArea(@PathVariable("area") @NotBlank String area, @RequestParam("authentication-key")
			@NotBlank String authKey){
		return pa.addNewArea(area, authKey).getAreas().stream().collect(Collectors.toList());
	}

	/**
	 * add a new property. authentication is required in form of @RequestParam as authentication-key.
	 * */
	@PostMapping("/addProperty/{property}")
	public List<String> addNewProperty(@PathVariable("property") @NotBlank String property, 
			@RequestParam("authentication-key") @NotBlank String authKey){
		return pa.addNewProperty(property, authKey).getProperties().stream().collect(Collectors.toList());
	}
	
	
}
