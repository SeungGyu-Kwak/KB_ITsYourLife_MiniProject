package cafe.service;

import java.util.List;

import cafe.dao.CoffeeDAO;
import cafe.dao.CoffeeDAOImpl;
import cafe.dao.OrderDAO;
import cafe.dao.OrderDAOImpl;
import cafe.dto.CoffeeDto;
import cafe.dto.OrderDto;
import cafe.exception.DMLException;
import cafe.exception.SearchWrongException;

public class CafeServiceImpl implements CafeService{
	
	private static CafeService instance = new CafeServiceImpl();
	
	private CoffeeDAO coffeeDAO = CoffeeDAOImpl.getInstance();
	private OrderDAO orderDAO = OrderDAOImpl.getInstance();
	
	private CafeServiceImpl() {}
	public static CafeService getInstance() {
		return instance;
	}
	
	
	@Override
	public List<CoffeeDto> selectAll() throws SearchWrongException {
		List<CoffeeDto> coffeeList = coffeeDAO.selectAll();	
		if(coffeeList.size()==0) {
			throw new SearchWrongException("게시물에 레코드가 없습니다.");
		}
		
		return coffeeList;
	}

	@Override
	public List<CoffeeDto> coffeeSelectByKeyWord(String keyWord) throws SearchWrongException {
		List<CoffeeDto> coffeeList = coffeeDAO.coffeeSelectByKeyWord(keyWord);
		
		if (coffeeList.size() == 0) {
			throw new SearchWrongException("해당 키워드를 가진 메뉴가 없습니다.");
		}
		return coffeeList;
	}
	@Override
	public void coffeeOrder(OrderDto dto) throws DMLException {
		int result = orderDAO.orderInsert(dto);
		if (result == 0) throw new DMLException("주문되지 않았습니다.");
	}
	

}