package com.tomwro.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FatherRowMapper implements RowMapper<Father> {

	@Override
	public Father mapRow(ResultSet rs, int rowNum) throws SQLException {
		Father father = new Father();
		
		father.setFatherId(rs.getInt("ID"));

		father.setBirthDate(rs.getDate("BirthDate"));
		father.setFirstName(rs.getString("FirstName"));
		father.setSecondName(rs.getString("SecondName"));
		father.setPESEL(rs.getString("PESEL"));
	
		return father;
	}

}
