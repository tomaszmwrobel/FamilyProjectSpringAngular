package com.tomwro.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ChildRowMapper implements RowMapper<Child> {

	@Override
	public Child mapRow(ResultSet rs, int rowNum) throws SQLException {
		Child child = new Child();
		
		child.setChildId(rs.getInt("ID"));
		
		child.setFirstName(rs.getString("FirstName"));
		child.setSecondName(rs.getString("SecondName"));
		child.setSex(rs.getString("Sex"));
		child.setPESEL(rs.getString("PESEL"));
		child.setBirthDate(rs.getDate("BirthDate"));
	
		return child;
	}

}
