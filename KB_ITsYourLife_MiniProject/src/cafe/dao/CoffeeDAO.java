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
	 * @사용하는 곳 : 콘솔창 2번 메뉴에서 키워드 검색으로 사용하는 곳
	 * select * from coffee where tbl_menu like ?
	 */
	List<CoffeeDto> coffeeSelectByKeyWord(String keyWord) throws SearchWrongException;
	

	/**
	 * 커피 메뉴에서 이름으로 검색  - 0개 또는 1개레코드 리턴! 
	 * @사용하는 곳 : orderDaoImpl 에서 orderDetails에서 사용할 것
	 * select * from coffee where tbl_menu where beverage_name = ? 
	 */
	CoffeeDto coffeeSelectByName(String beverageName) throws SearchWrongException;
}
