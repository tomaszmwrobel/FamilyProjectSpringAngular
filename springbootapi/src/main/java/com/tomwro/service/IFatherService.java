package com.tomwro.service;

import java.util.List;


import com.tomwro.entity.Father;

public interface IFatherService {

	List<Father> getAllfathers();
	
	Father getFatherById(int id);
	

    boolean addFather(Father father);
    void updateFather(Father father);
    void deleteFather(Father father);
	
	
}
