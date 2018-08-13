package com.tomwro.service;

import java.util.List;

import com.tomwro.entity.Family;

public interface IFamilyService {

	List<Family> getAllFamily();
	
	Family getFamilyById(int id);
	

    boolean addFamily(Family family);
	
	
}
