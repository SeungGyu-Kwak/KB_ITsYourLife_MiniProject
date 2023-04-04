package cafe.view;

import java.util.Scanner;

public class MenuView {
	static Scanner sc =new Scanner(System.in);

	/**
	 * 메뉴
	 * */
	public static void menuChoice() {
		while(true) {
			System.out.println("\n----------------------------------------");
			System.out.print("[ 1. 메뉴 검색   ");
			System.out.print("2. 커피(음료) 상세정보 보기  ");
			System.out.print("3. 주문하기 ");
			System.out.print("4. 종료 ]");

			System.out.println("\n--------------------------------------------");
			System.out.println("번호를 선택하세요 : ");
			try {
				int menu = Integer.parseInt(sc.nextLine());//
				switch (menu) {
				case 1:
					//BoardController.boardSelectByAll();	
					break;
				case 2:
					//inputBoardByno(); //존재하는 게시물
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
}
