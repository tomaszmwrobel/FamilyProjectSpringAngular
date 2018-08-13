package com.tomwro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomwro.dao.IFamilyDAO;
import com.tomwro.entity.Family;

@Service
public class FamilyService implements IFamilyService{
	
	@Autowired
	private IFamilyDAO familyDAO;

	@Override
	public List<Family> getAllFamily() {
		
		return familyDAO.getAllFamily();
	}

	@Override
	public Family getFamilyById(int id) {
	
		return familyDAO.getFamilyById(id);
	}

	@Override
	public boolean addFamily(Family family) {
		familyDAO.addFamily(family);
		return true;
	}


	

	
}
