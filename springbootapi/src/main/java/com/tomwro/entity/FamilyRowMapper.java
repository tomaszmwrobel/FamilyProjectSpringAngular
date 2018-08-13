package com.tomwro.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FamilyRowMapper implements RowMapper<Family> {

	@Override
	public Family mapRow(ResultSet rs, int rowNum) throws SQLException {
		Family family = new Family();
		
		family.setFamilyId(rs.getInt("ID"));

	
		return family;
	}

}
