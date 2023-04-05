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

	/**
	 * 주문하기
	 * @작성자 : 윤소민
	 */
	public static void inputOrder(String userID) {
		System.out.println("메뉴 이름을 입력해주세요 >");
		String menuName = sc.nextLine();

		System.out.println("HOT / ICE 고르세요 (1:HOT, 2:ICE) >");
		int kind = Integer.parseInt(sc.nextLine());


		System.out.println("메뉴 수량을 입력해주세요 >");
		int menuEA = Integer.parseInt(sc.nextLine());

		System.out.println("포장여부를 입력해주세요 (1:GO, 2:HERE) >");
		int G_H = Integer.parseInt(sc.nextLine());

		OrderDto order = new OrderDto(0,G_H,null, 0);  //총 결제금액 ?
		OrderDetailDto orderDetail = new OrderDetailDto(0,0,menuName,menuEA,kind);

		order.getOrderDetailList().add(orderDetail);
		CafeController.insertOrders(order);

	}
}//클래스 끝
