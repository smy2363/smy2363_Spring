package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.CoffeDto;

@Repository
public class CoffeDao {
	
	private final JdbcTemplate cf;
	
	@Autowired
	public CoffeDao(JdbcTemplate jdbcTemplate) {
		this.cf=jdbcTemplate;
	}
	
	public CoffeDto findId(int id) {
		String sql="select * from coffe where coffe_id=?";
		
		CoffeDto data=cf.queryForObject(sql,
				new RowMapper<CoffeDto>() {
			@Override
			public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				CoffeDto coffeDto = new CoffeDto();
				coffeDto.setItemName(rs.getString("item_name"));
				coffeDto.setPrice(rs.getInt("price"));
				coffeDto.setDecaffein(rs.getInt("decaffein"));
				coffeDto.setCoffeId(rs.getInt("coffe_id"));
				return coffeDto;
				}
			}
			,id);
		
		return data;
	}
	
	
	
	
	
	
	public List<CoffeDto> select(){
		String sql="select * from coffe";
		
		List<CoffeDto> li=cf.query(sql, new CoffeDtoRowMapper());
		
		return li;
	}
	
	
	public void insert(CoffeDto coffeDto) {
		String sql="insert into coffe(item_name, price, decaffein) values(?,?,?)";
		
		cf.update(sql , coffeDto.getItemName(), coffeDto.getPrice(), coffeDto.getDecaffein() );
	}
	
	public class CoffeDtoRowMapper implements RowMapper<CoffeDto>{

		@Override
		public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeDto coffeDto = new CoffeDto();
			coffeDto.setItemName(rs.getString("item_name"));
			coffeDto.setPrice(rs.getInt("price"));
			coffeDto.setDecaffein(rs.getInt("decaffein"));
			coffeDto.setCoffeId(rs.getInt("coffe_id"));
			return coffeDto;
		}
		
	
	}
	

}
