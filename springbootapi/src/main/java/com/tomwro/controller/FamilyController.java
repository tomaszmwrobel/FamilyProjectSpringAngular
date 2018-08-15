package com.tomwro.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.tomwro.entity.Child;
import com.tomwro.entity.Family;
//import com.tomwro.entity.Father;
import com.tomwro.service.IChildService;
import com.tomwro.service.IFamilyService;
import com.tomwro.service.IFatherService;

@Controller


@CrossOrigin(origins = "*") //Local Host Access
@RequestMapping("/api")
public class FamilyController {

	@Autowired
	private IFamilyService familyService;
	@Autowired
	private IFatherService fatherService;
	@Autowired
	private IChildService childService;
	
	
	@GetMapping("family/{id}")
	public ResponseEntity<Family> getFamilyById(@PathVariable("id") Integer id) {
		Family family = familyService.getFamilyById(id);
		family.setFatherFamily(fatherService.getFatherById(id));
		family.setChildFamily(childService.getAllChildWithID(id));
		return new ResponseEntity<Family>(family, HttpStatus.OK);
	}
	@PostMapping("/family")
	public ResponseEntity<Void> addFamily(@RequestBody Family family, UriComponentsBuilder builder) {
        boolean flag = familyService.addFamily(family);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
//###################### 		Dopracować zwrotkę 
        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("families")
	public ResponseEntity<List<Family>> getAllFamily() {
		List<Family> list = familyService.getAllFamily();
		
		for(Family f : list)
		{
			

			f.setFatherFamily(fatherService.getFatherById(f.getFamilyId()));
			f.setChildFamily(childService.getAllChildWithID(f.getFamilyId()));
			
				//System.out.println(">>>>" + f.getFamilyId());
			//System.out.println("+++" + tmp.getFirstName());
		}
		
			
	
		return new ResponseEntity<List<Family>>(list, HttpStatus.OK);
	}
	
	@GetMapping("families/search")
	public ResponseEntity<List<Family>> getAllFamilyWhere(
			  @RequestParam(value="firstName", required=false) String firstName,
		      @RequestParam(value="secondName", required=false) String secondName,
		      @RequestParam(value="pesel", required=false) String pesel,
		      @RequestParam(value="sex", required=false) String sex,
		      @RequestParam(value="birthDate", required=false) String birthDate
			) {
		
		List<Family> list = familyService.getAllFamily();
		List<Family> listSend = new ArrayList<>();
		
		//List<Father> listf = fatherService.getAllfathers();
		
		Map <String,String> map = new HashMap<>();
		if(firstName != null)
			map.put("FirstName", firstName);

		if(secondName != null)
			map.put("SecondName", secondName);

		if(sex != null)
			map.put("Sex", sex);

		if(pesel != null)
			map.put("PESEL", pesel);
		if(birthDate != null)
			map.put("BirthDate", birthDate);
		
		

		for(Family f : list)
		{
			List<Child> tmpList = childService.getAllChildWithIdWhere(f.getFamilyId(),map);
			
			if(tmpList.size()>0)
			{
				//System.out.println(tmpList.size());
				f.setChildFamily(tmpList);
				f.setFatherFamily(fatherService.getFatherById(f.getFamilyId()));
				listSend.add(f);
			}
			
		}
		
		
		
		//System.out.println(map);
			
	
		return new ResponseEntity<List<Family>>(listSend, HttpStatus.OK);
	}
	
	
	
	
}
