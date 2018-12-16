package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Check;
import kr.ac.hansung.model.Offer;

public class CheckDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	public int getRowCount() {
		String sqlStatement ="select count(*) from grade";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	public List<Check> getChecks() {
		String sqlStatement ="select * from grade";//?에 값이 들어감
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Check>(){//레코드를 자바의 객체로 맵핑해준다.

					
					public Check mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Check check = new Check();
						check.setYear(rs.getString("year"));
						check.setSemester(rs.getString("semester"));
						check.setCode(rs.getString("code"));
						check.setSubject(rs.getString("subject"));
						check.setKind(rs.getString("kind"));
						check.setPoint(rs.getInt("point"));
						return check;
					}
			
		});
		                                                                   
		
	}
	

}
