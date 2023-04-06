package cafe.view;

import java.util.List;

import cafe.dto.CoffeeDto;
import cafe.dto.OrderDetailDto;
import cafe.dto.OrderDto;

public class SuccessView {
	
	
	/**
	 * 카페 전체 메뉴 보여주는 메소드
	 * @작성자 : 윤소민
	 * */
	public static void selectPrint(List<CoffeeDto> list) {
		System.out.println("------------------Menu LIST ("+list.size()+") 개 ------------------");
		for(CoffeeDto menu : list) {
			System.out.println(menu);//board.toString()호출
		}
		
	}

	public static void messagePrint(String message) {
		System.out.println(message);
	}

	/**
	 * 카페 메뉴 중 키워드 검색해서 나온 결과 보여주는 메소드
	 * @작성자 : 곽승규
	 * */
	public static void selectByNamePrint(List<CoffeeDto> list, String keyword){
		System.out.println("------ 해당 키워드 " + keyword + " 검색결과(" + list.size() + "개) 입니다.-----");
		for(CoffeeDto menu: list) {
			System.out.println(menu); // CoffeeDto.toStrin()호출하는 것
		}
	}
	
	/**
	 * 주문 완료 되었을 때 주문내역 보여주는 메소드
	 * @작성자 : 곽승규
	 * */
	public static void orderListPrint(OrderDto order) {
		List<OrderDetailDto> orderDetailList = order.getOrderDetailList();
		System.out.println("---------- 주문내역 ----------");
		for (OrderDetailDto eachOrderDetail : orderDetailList) {
			String kind = eachOrderDetail.getKind() == 1 ? "HOT" : "ICE";
			System.out.print(eachOrderDetail.getMenuName() + "( "+ kind + ")     ");
			System.out.print(eachOrderDetail.getAmount() + "잔     ");
			System.out.print(eachOrderDetail.getEachPrice()+"원     ");
			System.out.println();
		}
		System.out.println("총 금액 : " + order.getTotalPrice());
		
	}

}
