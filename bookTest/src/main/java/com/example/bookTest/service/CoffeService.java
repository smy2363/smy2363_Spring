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
	
	//커피 메뉴 삭제
	public void remo(int del) {
		coffeDao.delete(del);
	}
	
	// 커피 상세 정보 가져오기
	public CoffeDto getCoffe(int id) {
		if(id != 0) {
			return coffeDao.findId(id);
		}
		
		return null;
	}
	
	
	// 커피정보 데이터베이스에서 가져와서  List에 저장되어있는거 받아서
	//control 에게 넘겨주기
	public List<CoffeDto> selectAll(){
		return coffeDao.select();
	}
	

	// 커피 정보 저장
	public void  coffeSave(CoffeDto coffeDto) {
		
		if(coffeDto != null) {
			coffeDao.insert(coffeDto);
		}
	}

	public void update(CoffeDto coffeDto) {
		coffeDao.update(coffeDto);
		
	}
	

}
