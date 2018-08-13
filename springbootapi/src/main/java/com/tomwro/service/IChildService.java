package com.tomwro.service;

import java.util.List;
import java.util.Map;

import com.tomwro.entity.Child;

public interface IChildService {

	List<Child> getAllChild();
	List<Child> getAllChildWithID(int id);
	List<Child> getAllChildWithIdWhere(int id, Map <String,String> map);
	Child getChildById(int id);
	

    boolean addChild(Child child);
    void updateChild(Child child);
    void deleteChild(Child child);
	
	
}
