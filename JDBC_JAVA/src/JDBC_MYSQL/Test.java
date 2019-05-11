package JDBC_MYSQL;

import java.util.HashMap;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Employee employee = new Employee();
		Manipulation maniObject = new Manipulation();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("Vui long chon thao tac ban muon thuc hien (A : Add, U : update, G : Get, D : Delete) : ");
		
		String mani = sc.nextLine();
		
		while(!( mani.equalsIgnoreCase("A") || mani.equalsIgnoreCase("U") || mani.equalsIgnoreCase("G") || mani.equalsIgnoreCase("D"))){
			System.out.println("Chuc nang ban chon khong co, vui long chon lai :");
			mani = sc.nextLine();
		}
		
		//Chon thao tac them nhan vien
		
		//Chon INSERT
		if(mani.equalsIgnoreCase("A")) {
			
			employee.input();
			
			int len = employee.employ.size();
			
			System.out.println("-----------------------KET QUA--------------------------");
			
			for(int i = 0; i<len; i++) {
				HashMap nv =(HashMap) employee.employ.get(i);
				employee.code = (String)nv.get("code");
				employee.name = (String)nv.get("name");
				employee.age = (int)nv.get("age");
				employee.genner = (String)nv.get("genner");
				employee.email = (String)nv.get("email");
				employee.phone = (String)nv.get("phone");
				employee.address = (String)nv.get("address");
				
				maniObject.add(employee);
				
			}
			
			System.out.println("Ban co muon lua chon mot chuc nang khac hay khong(Y : Yes, N : No) : ");
			String con = sc.nextLine();
			
			if(con.equalsIgnoreCase("N")) {
				System.out.println("-----Ung dung da dong------");
				break;
			}else {
				System.out.println("-----Thao tac moi------");
			}
		}
		
		//Chon UPDATE
		if(mani.equalsIgnoreCase("U")) {
			maniObject.update();
			
			System.out.println("Ban co muon lua chon mot chuc nang khac hay khong(Y : Yes, N : No) : ");
			String con = sc.nextLine();
			
			if(con.equalsIgnoreCase("N")) {
				System.out.println("-----Ung dung da dong------");
				break;
			}else {
				System.out.println("-----Thao tac moi------");
			}
			
		}
		
		//Chon DELETE
		if(mani.equalsIgnoreCase("D")) {
			maniObject.delete();
			
			System.out.println("Ban co muon lua chon mot chuc nang khac hay khong(Y : Yes, N : No) : ");
			String con = sc.nextLine();
			
			if(con.equalsIgnoreCase("N")) {
				System.out.println("-----Ung dung da dong------");
				break;
			}else {
				System.out.println("-----Thao tac moi------");
			}
		}
		
		//Chon GET 
		if(mani.equalsIgnoreCase("G")) {
			maniObject.get();
			
			System.out.println("Ban co muon lua chon mot chuc nang khac hay khong(Y : Yes, N : No) : ");
			String con = sc.nextLine();
			
			if(con.equalsIgnoreCase("N")) {
				System.out.println("-----Ung dung da dong------");
				break;
			}else {
				System.out.println("-----Thao tac moi------");
			}
		}
		
	}
	}
	}

