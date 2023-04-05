package cafe.service;

import java.util.List;

import cafe.dao.CoffeeDAO;
import cafe.dao.CoffeeDAOImpl;
import cafe.dto.CoffeeDto;
import cafe.exception.SearchWrongException;

public class CafeServiceImpl implements CafeService{
	
	private static CafeService instance = new CafeServiceImpl();
	private CoffeeDAO coffeeDAO = CoffeeDAOImpl.getInstance();
	
	private CafeServiceImpl() {}
	public static CafeService getInstance() {
		return instance;
	}
	
	
	@Override
	public List<CoffeeDto> selectAll() throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CoffeeDto> coffeeSelectByName(String keyWord) throws SearchWrongException {
		List<CoffeeDto> coffeList = coffeeDAO.coffeeSelectByName(keyWord);
		
		if (coffeList.size() == 0) {
			throw new SearchWrongException("해당 키워드를 가진 메뉴가 없습니다.");
		}
		return coffeList;
	}

}
