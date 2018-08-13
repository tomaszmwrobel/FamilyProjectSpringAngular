package com.tomwro.dao;

//import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.tomwro.entity.Father;
import com.tomwro.entity.FatherRowMapper;

@Transactional
@Repository
public class FatherDAO implements IFatherDAO{


	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public List<Father> getAllFathers() {
		String sql = "SELECT ID, FirstName, SecondName, BirthDate, PESEL FROM father";
		RowMapper<Father> rowMapper = new FatherRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Father getFatherById(int id) {
		
		Father father = new Father();
		String sql = "SELECT ID, BirthDate, FirstName,SecondName,PESEL FROM father WHERE ID = ?";
		RowMapper<Father> rowMapper = new FatherRowMapper();
		try {
		father = jdbcTemplate.queryForObject(sql, rowMapper, id);
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		
		//System.out.println(">>>>>>>>>>" + father);
		
		return father;
		
		
		
	}

	@Override
	public void addFather(Father father) {
		String sql = "INSERT INTO father (ID, BirthDate, FirstName, SecondName, PESEL) values (?, ?, ?, ? ,?)";
		jdbcTemplate.update(sql, father.getFatherId(), father.getBirthDate(), father.getFirstName(),father.getSecondName(),father.getPESEL());
	
	}

	@Override
	public void updateFather(Father father) {

		String sql = "UPDATE father SET BirthDate=?, FirstName=?, SecondName=?, PESEL=? WHERE ID=?";
		jdbcTemplate.update(sql, father.getBirthDate(), father.getFirstName(), father.getSecondName(),father.getPESEL(),father.getFatherId());
		
	}

	@Override
	public void deleteFather(Father father) {
		
		String sql = "DELETE FROM father WHERE ID=?";
		jdbcTemplate.update(sql, father.getFatherId());
		
	}

	@Override
	public boolean fatherExist(String firstName, String lastName, String pesel) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
