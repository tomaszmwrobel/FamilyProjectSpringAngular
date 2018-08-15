package com.tomwro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomwro.entity.Family;
import com.tomwro.entity.FamilyRowMapper;

@Transactional
@Repository
public class FamilyDAO implements IFamilyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Family> getAllFamily() {

		String sql = "SELECT ID FROM family";
		RowMapper<Family> rowMapper = new FamilyRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Family getFamilyById(int id) {

		String sql = "SELECT ID FROM family WHERE ID = ?";
		RowMapper<Family> rowMapper = new FamilyRowMapper();
		Family family = jdbcTemplate.queryForObject(sql, rowMapper, id);

		return family;
	}

	@Override
	public void addFamily(Family family) {
		String sql = "INSERT INTO family VALUES (null)";
		jdbcTemplate.update(sql);

	}

}
