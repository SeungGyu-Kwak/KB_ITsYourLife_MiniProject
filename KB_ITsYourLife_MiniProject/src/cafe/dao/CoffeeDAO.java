package cafe.dao;

import java.util.List;
import cafe.dto.CoffeeDto;

public interface CoffeeDAO {
	/**
	 * 커피 전체 정보검색하기
	 * select * from coffee;
	 * */
	public List<CoffeeDto> selectAll();
	

}
