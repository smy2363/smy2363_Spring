package com.example.bookTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.CoffeDto;

@Service
public class CoffeService {
	
	private final CoffeDao coffeDao;
	
	@Autowired
	public CoffeService(CoffeDao coffeDAO) {
		this.coffeDao=coffeDAO;
	}
	
	public void  coffeSave(CoffeDto coffeDto) {
		
		if(coffeDto != null) {
			coffeDao.insert(coffeDto);
		}
	}
	

}
