package com.metis.nopaper.work.master.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.metis.nopaper.work.master.MasterServiceConfig;
import com.metis.nopaper.work.master.dto.PropertiesDTO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("${v1API}")

public class MasterController {
	
	@Autowired
	private MasterServiceConfig masterServiceConfig;
	
	@Autowired
	private ModelMapper mapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MasterController.class);
	
	@GetMapping("properties")
	public String getPropertyDetails() throws JsonProcessingException {
		
		PropertiesDTO properties = mapper.map(masterServiceConfig, PropertiesDTO.class);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(properties);
	}
}
