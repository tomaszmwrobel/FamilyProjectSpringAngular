package com.tomwro.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomwro.dao.IChildDAO;

import com.tomwro.entity.Child;

@Service
public class ChildService implements IChildService {

	@Autowired
	private IChildDAO childDAO;

	@Override
	public List<Child> getAllChild() {

		return childDAO.getAllChild();
	}

	@Override
	public List<Child> getAllChildWithID(int id) {

		return childDAO.getAllChildWithId(id);
	}

	@Override
	public List<Child> getAllChildWithIdWhere(int id, Map<String, String> map) {

		return childDAO.getAllChildWithIdWhere(id, map);
	}

	@Override
	public Child getChildById(int id) {
		Child obj = childDAO.getChildById(id);
		return obj;
	}

	@Override
	public boolean addChild(Child child) {
		childDAO.addChild(child);
		return true;
	}

	@Override
	public void updateChild(Child child) {

		childDAO.updateChild(child);

	}

	@Override
	public void deleteChild(Child child) {
		childDAO.updateChild(child);

	}

}
