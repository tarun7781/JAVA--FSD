package com.mphasis.spring.SpringJdbcAOPDemo.Db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDB {

	@Autowired
	private JdbcTemplate template;
	
	public long count()
	{
		String sql ="select count(*) from employee";
		return this.template.queryForObject(sql, Long.class);
	}
	
}
