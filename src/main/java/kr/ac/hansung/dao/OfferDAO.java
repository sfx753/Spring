package kr.ac.hansung.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;


@Repository("offerDAO")
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {//datasource를 의존성에 의해 주입할 예정 이때 ->jdbcTemplate 객체에 저장
		jdbcTemplate =new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from register";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	//query and return a single object(레코드를 조회하고 삽입하고 변경하고 삭제하는 내용 구현)
	
	//레코드 읽어오기
	public Offer getOffer(String name) {
		String sqlStatement ="select * from register where name=?";//?에 값이 들어감
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
				new RowMapper<Offer>(){//레코드를 자바의 객체로 맵핑해준다.

					
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						offer.setId(rs.getInt("id"));
						offer.setCode(rs.getString("code"));
						offer.setSubject(rs.getString("subject"));
						offer.setClasses(rs.getString("classes"));
						
						return offer;
					}
			
		});
		                                                                   
		
	}
	//모든 레코드 읽기
	public List<Offer> getOffers() {
		String sqlStatement ="select * from register";//?에 값이 들어감
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Offer>(){//레코드를 자바의 객체로 맵핑해준다.

					
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						offer.setId(rs.getInt("id"));
						offer.setCode(rs.getString("code"));
						offer.setSubject(rs.getString("subject"));
						offer.setClasses(rs.getString("classes"));
						
						return offer;
					}
			
		});
		                                                                   
		
	}
	
	public boolean insert(Offer offer) {
	
		String code =offer.getCode();
		String subject = offer.getSubject();
		String classes= offer.getClasses();
		
		String sqlStatement="insert into register(code, subject, classes) values(?,?,?)";
		return (jdbcTemplate.update(sqlStatement,new Object[] {code, subject, classes})==1);//int값 개수가 return 됨
	}
	
	public boolean update(Offer offer) {//id 값이 일치하는 데이터를 수정
		int id =offer.getId();
		String code =offer.getCode();
		String subject = offer.getSubject();
		String classes= offer.getClasses();
		
		String sqlStatement="update register set name=?, email=?,text=? where id=?";
		return (jdbcTemplate.update(sqlStatement,new Object[] {code,subject,classes,id})==1);
	}
	
	public boolean delete(int id) {
		String sqlStatement="delete from register where id=?";
		return (jdbcTemplate.update(sqlStatement,new Object[] {id})==1);
	}
	
}
