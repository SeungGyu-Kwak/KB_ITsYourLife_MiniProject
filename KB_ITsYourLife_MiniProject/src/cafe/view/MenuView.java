package cafe.view;

import java.util.Scanner;

import cafe.controller.CafeController;

public class MenuView {
	static Scanner sc =new Scanner(System.in);

	/**
	 * 메뉴
	 * @작성자 : 곽승규, 윤소민
	 * */
	public static void menuChoice() {
		while(true) {
			System.out.println("\n------------------------------------------------------------------");
			System.out.print("[ 1. 메뉴 검색   ");
			System.out.print("2. 커피(음료) 상세정보 보기  ");
			System.out.print("3. 주문하기 ");
			System.out.print("4. 종료 ]");

			System.out.println("\n------------------------------------------------------------------");
			System.out.println("번호를 선택하세요 : ");
			try {
				int menu = Integer.parseInt(sc.nextLine());//
				switch (menu) {
				case 1:
					CafeController.coffeeSelectByAll();
					break;
				case 2:
					inputCoffeeByName();
					break;
				case 3:
					//inputBoardBySubject();
					break;
				case 4:
					System.out.println("다음에 다시 만나요~~^^ 로그아웃됩니다...");
					System.exit(0);	
					break;

				default:
					System.out.println("잘못되었습니다..다시 입력해주세요.");
				}

			}catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
		}//while문
	}
	
	
	/**
	 * 메뉴검색 
	 * @작성자 : 곽승규
	 * */
	public static void inputCoffeeByName() {
		System.out.println("어떤 커피 정보를 보시겠습니까 ? > ");
		String keyWord = sc.nextLine();
		CafeController.coffeeSelectByName(keyWord);
	}
}//클래스 끝
