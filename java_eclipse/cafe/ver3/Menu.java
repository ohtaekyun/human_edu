package Cafe2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private ArrayList<String> alName; // 메뉴명 목록
	private ArrayList<Integer> alPrice;	// 메뉴가격 목록
	
	Menu(){
		this.alName=new ArrayList<String>();
		this.alPrice=new ArrayList<Integer>();
		// d:\temp\menu.txt를 찾고 열어서 메뉴명/가격을 읽어들인다.
		File file = new File("d:\\temp\\menu.txt");
		 
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8))
        {
            while (sc.hasNextLine()) {
            	String line=sc.nextLine();
            	String[] token=line.split(","); // ["Americano","2500"]
            	this.alName.add(token[0]);
            	this.alPrice.add(Integer.parseInt(token[1]));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	private void save() {
		// alName,alPrice의 메뉴명,가격을 menu.txt에 쓰기(저장)
		try {
            File file = new File("d:\\temp\\menu.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            PrintWriter writer = new PrintWriter(fw);
            for(int i=0; i<this.alName.size(); i++) {
            	writer.write(this.alName.get(i)+","+this.alPrice.get(i)+"\n");
            }
            writer.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
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
	}
	String getName(int ndx) {
		return this.alName.get(ndx);
	}
	int getPrice(int ndx) {
		return this.alPrice.get(ndx);
	}
	void display() {
		for(int i=0; i<this.alName.size(); i++) {
			System.out.println((i+1)+"."+this.alName.get(i)
					+", "+this.alPrice.get(i));
		}
	}
	void control() {
		Scanner s1 = new Scanner(System.in); // 문자열 입력전용
		Scanner s2 = new Scanner(System.in); // 숫자 입력전용
		
		while(true) {
			System.out.print("메뉴작업을 선택하시오 [c:추가,r:목록표시,u:수정,d:삭제,'':종료]:");
			String instr = s1.nextLine();
			if(instr.equals("")) {
				this.save();
				break;
			} else if(instr.equals("c")) {
				String name=s1.nextLine();
				int price=s2.nextInt();
				this.add(name, price);
			} else if(instr.equals("r")) {
				this.display();
			} else if(instr.equals("u")) {
				int ndx=s2.nextInt();
				String name=s1.nextLine();
				int price=s2.nextInt();
				this.update(ndx,name,price);
			} else if(instr.equals("d")) {
				int ndx=s2.nextInt();
				this.delete(ndx-1);
			}
		}
	}
}
