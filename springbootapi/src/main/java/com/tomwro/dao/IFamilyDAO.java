package com.tomwro.dao;

import java.util.List;

import com.tomwro.entity.Family;

public interface IFamilyDAO {
	List<Family> getAllFamily();
	
	Family getFamilyById(int id);
	

	
	void addFamily(Family family);
	
}
