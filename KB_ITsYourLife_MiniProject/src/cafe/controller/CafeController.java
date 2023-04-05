package cafe.controller;

import java.util.List;

import cafe.dto.CoffeeDto;
import cafe.dto.OrderDto;
import cafe.exception.DMLException;
import cafe.exception.SearchWrongException;
import cafe.service.CafeService;
import cafe.service.CafeServiceImpl;
import cafe.view.FailView;
import cafe.view.SuccessView;

public class CafeController {

	private static CafeService cafeService = CafeServiceImpl.getInstance();
	
	/**
	 * 카페메뉴 전체 보기
	 * @작성자 : 윤소민
	 * */
	public static void coffeeSelectByAll() {
		try {
			List<CoffeeDto> coffeeList = cafeService.selectAll();
			SuccessView.selectPrint(coffeeList);
		}catch(SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 카페메뉴 이름 쳐서 해당 메뉴 상세 정보 보기
	 * @작성자 : 곽승규
	 * */
	public static void coffeeSelectByName(String keyWord) {
		try {
			List<CoffeeDto>coffeeList = cafeService.coffeeSelectByName(keyWord);
			SuccessView.selectByNamePrint(coffeeList, keyWord);
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/** CafeControllerImpl 
	 * 주문하기
	 */
	public static void insertOrders(OrderDto order) {
		try {
			cafeService.coffeeOrder(order);
			SuccessView.messagePrint("주문되었습니다.");
		}catch(DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
