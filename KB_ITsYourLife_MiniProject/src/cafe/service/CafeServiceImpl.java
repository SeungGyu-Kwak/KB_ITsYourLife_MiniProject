package cafe.service;

import java.util.List;

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
		
		return null;
	}

	@Override
	public List<CoffeeDto> coffeeSelectByName(String keyWord) throws SearchWrongException {
		
		return null;
	}

}