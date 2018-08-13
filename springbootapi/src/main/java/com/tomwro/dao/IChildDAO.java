package com.tomwro.dao;

import java.util.List;
import java.util.Map;

import com.tomwro.entity.Child;

public interface IChildDAO {
	List<Child> getAllChild();

	List<Child> getAllChildWithId(int id);
	

	List<Child> getAllChildWithIdWhere(int id,  Map<String,String> params);
	
	Child getChildById(int id);
	
	void addChild(Child child);
	void updateChild(Child child);
	void deleteChild(Child child);
	
	
}
