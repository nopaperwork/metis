package com.talic.cs.wallet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talic.cs.wallet.dto.DummyObject;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("${v1API}")
@CrossOrigin(origins = "*", maxAge = 3600)
public class WalletController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WalletController.class);
	
	@PostMapping(value = { "dummyRequestObject" }, produces = "application/json")
	public ResponseEntity<String> dummyRequestObject(@RequestBody @Valid DummyObject dummyObject) {

		String postResponse = "You have passed : " + dummyObject.getRequestString();

		LOGGER.info(postResponse);
		
		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}
	
}
