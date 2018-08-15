package com.tomwro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.tomwro.entity.Family;
import com.tomwro.entity.Father;
import com.tomwro.service.IFamilyService;
//import com.tomwro.service.IFamilyService;
import com.tomwro.service.IFatherService;

@Controller

@CrossOrigin(origins = "*") // Local Host Access
@RequestMapping("/api")
public class FatherController {

	@Autowired
	private IFatherService fatherService;
	@Autowired
	private IFamilyService familyService;

	/*Get Fathe by ID*/
	@GetMapping("father/{id}")
	public ResponseEntity<Father> getFatherById(@PathVariable("id") Integer id) {
		Father father = fatherService.getFatherById(id);
		return new ResponseEntity<Father>(father, HttpStatus.OK);
	}
	
	/* Create Family Add Father to Family*/
	@PostMapping("/father")
	public ResponseEntity<Father> addFather(@RequestBody Father father, UriComponentsBuilder builder) {

		// Create Family
		Family tmpFamily = new Family();
		familyService.addFamily(tmpFamily);
		
		//Search last Family ID
		List<Family> tmp = familyService.getAllFamily();
		tmpFamily = tmp.get(tmp.size() - 1);
		int index = tmpFamily.getFamilyId();
		
		//Set Father ID
		father.setFatherId(index);

		//Create Father
		fatherService.addFather(father);

		return new ResponseEntity<Father>(father, HttpStatus.CREATED);
	}

	
	@GetMapping("fathers")
	public ResponseEntity<List<Father>> getAllFathers() {
		List<Father> list = fatherService.getAllfathers();
		return new ResponseEntity<List<Father>>(list, HttpStatus.OK);
	}

	@PutMapping("father")
	public ResponseEntity<Father> updateFather(@RequestBody Father father) {
		fatherService.updateFather(father);
		return new ResponseEntity<Father>(father, HttpStatus.OK);
	}

	@DeleteMapping("father")
	public ResponseEntity<Void> deleteFather(@RequestBody Father father) {
		fatherService.deleteFather(father);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
