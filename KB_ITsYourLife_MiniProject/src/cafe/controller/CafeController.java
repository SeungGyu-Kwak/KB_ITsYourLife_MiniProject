package cafe.controller;

import java.util.List;

import cafe.dto.CoffeeDto;
import cafe.exception.SearchWrongException;
import cafe.service.CafeService;
import cafe.service.CafeServiceImpl;
import cafe.view.FailView;
import cafe.view.SuccessView;

public class CafeController {

	private static CafeService cafeService = CafeServiceImpl.getInstance();
	
	/**
	 * 카페메뉴 전체 검색
	 * @작성자 : 윤소민
	 * */
	
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
}
