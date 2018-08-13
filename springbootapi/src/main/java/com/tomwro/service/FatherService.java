package com.tomwro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tomwro.dao.IFatherDAO;
import com.tomwro.entity.Father;

@Service
public class FatherService implements IFatherService{
	
	@Autowired
	private IFatherDAO fatherDAO;
	@Override
	public List<Father> getAllfathers() {

		return fatherDAO.getAllFathers();
	}

	@Override
	public Father getFatherById(int id) {
		
		Father obj = fatherDAO.getFatherById(id);
		return obj;
	}

	@Override
	public boolean addFather(Father father) {
		fatherDAO.addFather(father);
		return true;
	}

	@Override
	public void updateFather(Father father) {
		fatherDAO.updateFather(father);
		
	}

	@Override
	public void deleteFather(Father father)
	{
		fatherDAO.deleteFather(father);
		
	}

	
}
