package com.tomwro.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomwro.entity.Child;
import com.tomwro.entity.ChildRowMapper;

@Transactional
@Repository
public class ChildDAO implements IChildDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Child> getAllChild() {
		String sql = "SELECT ID, FirstName, SecondName, Sex, PESEL, BirthDate FROM child";
		RowMapper<Child> rowMapper = new ChildRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Child> getAllChildWithId(int id) {

		List<Child> tmp = new ArrayList<>();

		String sql = "SELECT ID, FirstName, SecondName, Sex, PESEL, BirthDate FROM child WHERE ID = ?";
		RowMapper<Child> rowMapper = new ChildRowMapper();
		try {
			tmp = this.jdbcTemplate.query(sql, rowMapper, id);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return tmp;
	}

	@Override
	public List<Child> getAllChildWithIdWhere(int id, Map<String, String> params) {

		List<Child> tmp = new ArrayList<>();
		// String sql = "SELECT * FROM child WHERE ID = ?";

		String sql = sqlGenerator(id, params);

		RowMapper<Child> rowMapper = new ChildRowMapper();
		try {
			tmp = this.jdbcTemplate.query(sql, rowMapper);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return tmp;
	}

	public String sqlGenerator(int id, Map<String, String> params) {
		StringBuilder sql = new StringBuilder("SELECT * FROM child ");
		StringBuilder whereClause = new StringBuilder(" WHERE ID = " + id + " AND ");
		String andOp = "";

		for (Map.Entry<String, String> entry : params.entrySet()) {
			// System.out.println(entry.getKey() + ":" + entry.getValue());
			whereClause.append(andOp);
			whereClause.append(" ");
			whereClause.append(entry.getKey());
			whereClause.append("= '" + entry.getValue() + "' ");
			andOp = " AND ";
		}

		sql.append(whereClause);

		// System.out.println(">>>>>>>>>>"+sql);
		return sql.toString();
	}

	@Override
	public Child getChildById(int id) {
		String sql = "SELECT ID, FirstName,SecondName, Sex, PESEL, BirthDate FROM child WHERE ID = ?";
		RowMapper<Child> rowMapper = new ChildRowMapper();
		Child child = jdbcTemplate.queryForObject(sql, rowMapper, id);

		return child;
	}

	@Override
	public void addChild(Child child) {

		String sql = "INSERT INTO child (ID, FirstName, SecondName,Sex, PESEL, BirthDate) values (?, ?, ?, ? ,?, ?)";
		jdbcTemplate.update(sql, child.getChildId(), child.getFirstName(), child.getSecondName(), child.getSex(),
				child.getPESEL(), child.getBirthDate());

	}

	@Override
	public void updateChild(Child child) {
		String sql = "UPDATE child SET FirstName=?, SecondName=?,Sex=?, PESEL=?, BirthDate=? WHERE ID=?";
		jdbcTemplate.update(sql, child.getFirstName(), child.getSecondName(), child.getSex(), child.getPESEL(),
				child.getChildId(), child.getBirthDate());

	}

	@Override
	public void deleteChild(Child child) {

		String sql = "DELETE FROM child WHERE ID=?";
		jdbcTemplate.update(sql, child.getChildId());

	}

}
