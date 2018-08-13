package com.tomwro.dao;

import java.util.List;

import com.tomwro.entity.Father;

public interface IFatherDAO {
	List<Father> getAllFathers();
	
	Father getFatherById(int id);
	
	void addFather(Father father);
	void updateFather(Father father);
	void deleteFather(Father father);
	
	boolean fatherExist(String firstName, String lastName, String pesel);
	
}
