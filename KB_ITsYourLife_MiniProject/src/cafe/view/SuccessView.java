package cafe.view;

import java.util.List;

import cafe.dto.CoffeeDto;

public class SuccessView {
	
	
	/**
	 * 카페 전체 메뉴 보여주는 메소드
	 * */
	public static void selectPrint(List<CoffeeDto> list) {
		System.out.println("----Menu LIST ("+list.size()+") 개 ------------------");
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

}
