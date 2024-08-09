package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.CoffeDto;

@Service
public class CoffeService {
	@Autowired
	private  CoffeDao coffeDao;
	
	
	public CoffeDto getCoffe(int id) {
		if(id != 0) {
			return coffeDao.findId(id);
		}
		
		return null;
	}
	
	

	public List<CoffeDto> selectAll(){
		return coffeDao.select();
	}
	

	
	public void  coffeSave(CoffeDto coffeDto) {
		
		if(coffeDto != null) {
			coffeDao.insert(coffeDto);
		}
	}
	

}
