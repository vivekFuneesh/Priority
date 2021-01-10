package com.vivek.priority.controller;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.priority.dto.UserDto;
import com.vivek.priority.service.ProcessUsers;

@RestController
@Validated
public class UserController {

	@Autowired
	ProcessUsers pu;
	
	@Autowired
	ModelMapper mm;
	
	/**
	 * Users can submit their ratings in particular areas.
	 * Name is used as unique key to identify users.. though it is not good strategy.
	 * Property can be "priority", "satisfaction", "key-notes" etc.
	 * */
	@PostMapping("/addRatings/{name}/{area}/{property}/{value}")
	public UserDto addRatings(@PathVariable("name") @NotBlank String name, @PathVariable("area") @NotBlank String area, 
			@PathVariable("property") @NotBlank String property, @PathVariable("value") @NotBlank String value) {
		return mm.map(pu.fillPropertyAndValueOfAreaForUser(name, area, property, value),UserDto.class);
	}
	
	
}
