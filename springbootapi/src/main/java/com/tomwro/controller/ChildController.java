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

import com.tomwro.entity.Child;
import com.tomwro.service.IChildService;

@Controller

@CrossOrigin(origins = "*") // Local Host Access
@RequestMapping("/api")
public class ChildController {

	@Autowired
	private IChildService childService;
	
	/* Get Child By ID*/
	@GetMapping("child/{id}")
	public ResponseEntity<Child> getChildById(@PathVariable("id") Integer id) {
		Child child = childService.getChildById(id);
		return new ResponseEntity<Child>(child, HttpStatus.OK);
	}

	/** Add Child to Family*/
	
	@PostMapping("/child")
	public ResponseEntity<Void> addChild(@RequestBody Child child, UriComponentsBuilder builder) {
		boolean flag = childService.addChild(child);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	/*Get all Children from DB*/
	@GetMapping("children")
	public ResponseEntity<List<Child>> getAllChild() {
		List<Child> list = childService.getAllChild();
		return new ResponseEntity<List<Child>>(list, HttpStatus.OK);
	}
	
	/*Get All Child with id*/
	@GetMapping("children/{id}")
	public ResponseEntity<List<Child>> getAllChildWithId(@PathVariable("id") Integer id) {
		List<Child> list = childService.getAllChildWithID(id);
		return new ResponseEntity<List<Child>>(list, HttpStatus.OK);
	}

	
	/* PUT */
	@PutMapping("child")
	public ResponseEntity<Child> updateChild(@RequestBody Child child) {
		childService.updateChild(child);
		return new ResponseEntity<Child>(child, HttpStatus.OK);
	}
	/*DELETE*/
	@DeleteMapping("child")
	public ResponseEntity<Void> deleteChild(@RequestBody Child child) {
		childService.deleteChild(child);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
