package Cafe;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	private ArrayList<String> alName;
	private ArrayList<Integer> alQty;
	private ArrayList<Integer> alPrice; // 합계 (단가x수량)
	private String mobile;
	private Menu m1;
	
	Order(Menu m){
		this.alName=new ArrayList<String>();
		this.alQty=new ArrayList<Integer>();
		this.alPrice=new ArrayList<Integer>();
		this.mobile="";
		this.m1 = m;
	}
	void add() {
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		while(true) {
			this.m1.display();
			// 메뉴번호를 입력받는다 (""이 아닌 동안)
			System.out.print("메뉴번호를 입력하시오['':종료]");
			String pMenuNum=s1.nextLine();
			if(pMenuNum.equals("")) break;
			
			int ndx = Integer.parseInt(pMenuNum)-1; // 메뉴번호->메뉴인덱스
			String name = this.m1.getName(ndx);
			int net=this.m1.getPrice(ndx);
			System.out.print("수량을 입력하시오:");// 수량을 입력받는다
			int qty = s2.nextInt();
			// alName/alQty/alPrice에 각각 추가
			this.alName.add(name);
			this.alQty.add(qty);
			this.alPrice.add(qty*net);// 단가x수량=> 합계를 계산
		}
		System.out.print("모바일번호를 입력하시오:");
		this.mobile = s1.nextLine();// 모바일번호 입력받는다
		
	}
	void display() {
		int sum=0;
		for(int i=0; i<this.alName.size(); i++) {
			System.out.println((i+1)+"."+this.alName.get(i)+
					", x"+this.alQty.get(i)+", "+
					this.alPrice.get(i)+"원");
			sum+=this.alPrice.get(i);
		}
		System.out.println("총액:"+sum+", 모바일번호:"+this.mobile);
	}
	void delete() {
		Scanner s = new Scanner(System.in);
		while(true) {
			this.m1.display();
			System.out.print("지울 주문내역번호를 입력하시오['':종료]");
			String pMenuNum=s.nextLine();
			if(pMenuNum.equals("")) break;
			
			int ndx = Integer.parseInt(pMenuNum)-1;
			this.alName.remove(ndx);
			this.alQty.remove(ndx);
			this.alPrice.remove(ndx);
		}
	}
	void control() {
		Scanner s1 = new Scanner(System.in); // 문자열 입력전용
		Scanner s2 = new Scanner(System.in); // 숫자 입력전용
		
		while(true) {
			System.out.print("주문작업을 선택하시오 [c:추가,r:내역표시,u:수정,d:삭제,'':종료]:");
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
	int getSize() {
		return this.alName.size();
	}
	String getName(int ndx) {
		return this.alName.get(ndx);
	}
	int getQty(int ndx) {
		return this.alQty.get(ndx);
	}
	int getPrice(int ndx) {
		return this.alPrice.get(ndx);
	}
	String getMobile() {
		return this.mobile;
	}
}
