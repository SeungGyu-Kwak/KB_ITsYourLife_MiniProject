package cafe.service;

import java.util.List;

import cafe.dto.CoffeeDto;
import cafe.exception.SearchWrongException;

public interface CafeService {

	/**
	 * 모든 커피 메뉴 검색
	 */
	List<CoffeeDto> selectAll() throws SearchWrongException;
	
	/**
	 * 커피메뉴에 키워드 입력해서 상세정보 보기
	 * */
	List<CoffeeDto> coffeeSelectByName(String keyWord) throws SearchWrongException;
}
