package cafe.dao;

import java.util.List;

import cafe.dto.CoffeeDto;
import cafe.exception.SearchWrongException;


public interface CoffeeDAO {
	/**
	 * 커피 전체 정보검색하기
	 * select * from coffee;
	 * */
	public List<CoffeeDto> selectAll() throws SearchWrongException;
	
	
	/**
	 * 커피 메뉴에 특정 문자열이 포함된 레코드 검색 - 0개이상의 레코드 리턴!!!
	 * select * from coffee where subject like ?
	 */
	List<CoffeeDto> coffeeSelectByName(String keyWord) throws SearchWrongException;
	

}
