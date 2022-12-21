import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {
		Menu menu = new Menu();
		
		Scanner sc = new Scanner(System.in);
		while(true) {

			System.out.println("작업선택 [m:메뉴작업, o:주문관리, s:매출조회]");
			String op = sc.nextLine();
			if(op.equals("m")) {
				menu.control();
			}
			else if(op.equals("o")) {
				System.out.println("주문관리");
				Order order = new Order(menu);
				order.control();
			}
			else if(op.equals("s")) {
				System.out.println("매출조회");
			}
			else if(op.equals(""))  {
				break;
			}
		}
		System.out.println("종료");
		sc.close();
		
		

	}
	
	


}
