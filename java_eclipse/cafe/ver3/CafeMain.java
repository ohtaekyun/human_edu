package Cafe2;

import java.util.Scanner;

public class CafeMain {
	public static void main(String[] args) {
		Menu menu = new Menu();
		Sales sales = new Sales();
		
		Scanner s= new Scanner(System.in);
		while(true) {
			System.out.println("작업선택 [m:메뉴작업,o:주문관리,s:매출조회,'':종료]");
			String op=s.nextLine();
			if(op.equals("m")) {
				menu.control();
			} else if(op.equals("o")) {
				Order order = new Order(menu); // 초기화 & 리셋
				order.control();
				sales.add(order);
			} else if(op.equals("s")) {
				sales.display();
			} else if(op.equals("")){
				sales.save();
				break;
			}
		}
		s.close();
		System.out.println("프로그램 종료");
	}
}
