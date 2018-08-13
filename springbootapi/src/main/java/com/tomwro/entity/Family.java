package com.tomwro.entity;

import java.util.List;

public class Family {
	
	private int familyId;
	private Father fatherFamily;
	private List<Child> childFamily;
	
	
	
	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public Father getFatherFamily() {
		return fatherFamily;
	}

	public void setFatherFamily(Father fatherFamily) {
		this.fatherFamily = fatherFamily;
	}

	public List<Child> getChildFamily() {
		return childFamily;
	}

	public void setChildFamily(List<Child> childFamily) {
		this.childFamily = childFamily;
	}

	
	
	
}
