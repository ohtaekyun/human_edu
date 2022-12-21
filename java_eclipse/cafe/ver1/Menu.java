import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private ArrayList<String> alName;
	private ArrayList<Integer> alPrice;
	
	Menu(){
		this.alName = new ArrayList<String>();
		this.alPrice = new ArrayList<Integer>();
		//alName, alPrice 초기화(initialize)
	}
	private void add(String name, int price) {
		this.alName.add(name);
		this.alPrice.add(price);
	}
	private void delete(int index) {
		this.alName.remove(index);
		this.alPrice.remove(index);
	}
	private void update(int index, String name, int price) {
		this.alName.set(index, name);
		this.alPrice.set(index, price);
		
		// alName, alPrice 양쪽에서 index번호의 이름과 가격을 수정
	}
	String getName(int n) {
		return this.alName.get(n);
	}
	int getPrice(int n) {
		return this.alPrice.get(n);
	}
	void display() {
		// 메뉴명과 가격을 표시
		/* Americano, 2500
		 * Mocca, 3200
		 * Espresso, 2700
		 */
		
		for(int i=0;i<alName.size();i++) {
			System.out.printf("메뉴: %s, 가격: %d원\n",this.alName.get(i),this.alPrice.get(i));
		}
	}
	void control() {
		Scanner s1 = new Scanner(System.in); //문자열 입력전용
		Scanner s2 = new Scanner(System.in); //숫자 입력전용
				
		while(true) {
			System.out.print("작업을 선택하시오 [c:추가, r:목록표시, u:수정, d:삭제, '':뒤로]");
			String instr = s1.nextLine();
			if(instr=="") {
				break;
			}
			else if(instr.equals("c")) {
				System.out.println("메뉴명을 입력하세요");
				String menu1 = s1.nextLine();
				System.out.println("가격을 입력하세요");
				int price1 = Integer.parseInt(s2.nextLine());
				this.add(menu1, price1);
				System.out.printf("%s메뉴가 %d원 가격으로 추가되었습니다\n",menu1,price1);
				
			}
			else if(instr.equals("r")) {this.display();}
			else if(instr.equals("u")) {//수정할 메뉴의 인덱스번호 입력받고
				//새 이름, 가격, 인덱스 입력받고
				System.out.println("인덱스번호를 입력하세요");
				int ndx=s2.nextInt();
				System.out.println("새 이름을 입력하세요");
				String name = s1.nextLine();
				System.out.println("새 가격을 입력하세요");
				int price = s2.nextInt();
				this.update(ndx, name, price);}
				
//				System.out.println("새 인덱스번호를 입력하세요");
				
				
			else if(instr.equals("d")) {
				System.out.print("인덱스번호를 입력하세요");
				int ndx=s2.nextInt();
				this.delete(ndx);
				}
		}
//		System.out.println("프로그램종료");
//		s1.close();
//		s2.close();
	}
}
