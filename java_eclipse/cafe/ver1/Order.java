import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	
	private ArrayList<String> alName;
	private ArrayList<String> alPhone;
	private ArrayList<Integer> alQty;
	private ArrayList<Integer> alPrice; //합계(단가x수량)
	private String mobile;
	private Menu m1;

	Scanner s1 = new Scanner(System.in); //문자열 입력전용
	Scanner s2 = new Scanner(System.in); //숫자 입력전용
	
	Order(Menu m){ //초기화
		this.m1=m;
		this.alName = new ArrayList<String>();
		this.alPrice = new ArrayList<Integer>();
		this.alQty = new ArrayList<Integer>();
		this.alPhone = new ArrayList<String>();
	}
	void add() {

		
		
		
		
		
		
		System.out.print("메뉴번호를 입력하세요");
		int instr1 = s2.nextInt();
		String name=m1.getName(instr1-1);
		
		System.out.print("수량을 입력하세요");
		int instr2 = s2.nextInt();
		int instr3 = instr2*m1.getPrice(instr1-1);
		
		System.out.print("모바일번호를 입력하세요");
		String instr4 = s1.nextLine();
		
		this.alName.add(name);
		this.alQty.add(instr2);
		this.alPrice.add(instr3);
		this.alPhone.add(instr4);
//		
		
		//메뉴번호를 입력받는다(""이 아닌동안)
		//수량을 입력받는다
		//단가x수량 = 금액 합계를 계산
		//alName/alQty/alPrice에 각각 추가
		//모바일번호 입력
		
	}
	void display() {   // 주문내역을 출력(화면표시)
		int sum=0;
		for(int i=0;i<alName.size();i++) {
			
			System.out.printf("메뉴: %s, 갯수: %d개, 총금액: %d, 번호: %s\n",this.alName.get(i),this.alQty.get(i),this.alPrice.get(i),this.alPhone.get(i));
			sum+=this.alPrice.get(i);
		}
		System.out.printf("총액: %d원",sum);
		
	}

	void delete() {
		//취소할 주문번호를 입력받는다(""이 아닌동안)
		//주문 삭제
		System.out.print("삭제할 주문번호를 입력하세요");
		int index = s2.nextInt();
		this.alName.remove(index-1);
		this.alQty.remove(index-1);
		this.alPrice.remove(index-1);
		
	}
	void control() {
				
		while(true) {
			System.out.print("작업을 선택하시오 [c:추가, r:내역표시, d:삭제, '':종료]");
			String instr = s1.nextLine();
			if(instr.equals("")) {
				break;
			} else if(instr.equals("c")) {
				this.add();
			} else if(instr.equals("r")) {
				this.display();
			} else if(instr.equals("d")) {
				this.delete();
			}
		}
	}
}
