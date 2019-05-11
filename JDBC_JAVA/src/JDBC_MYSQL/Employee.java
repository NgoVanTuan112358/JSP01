package JDBC_MYSQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Employee {
	String code;
	String name;
	int age;
	String genner;
	String email;
	String phone;
	String address;
	String time;
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGenner() {
		return genner;
	}

	public void setGenner(String genner) {
		this.genner = genner;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	//IMPUT INFORMATION
	
	ArrayList employ = new ArrayList(); //Mang chua nhan vien nhap vao
	
	public void input() {
		Scanner sc =new Scanner(System.in);
		
		int count = 1;
		
		while(true) {
			HashMap hashNV = new HashMap(); //HashMap chua thong cua mot nhan vien
			System.out.println("-----------------------------------------");
			System.out.println("Nhap thong tin nhan vien thu "+count+" : ");
			System.out.println("");
			
			//--Ma nhan vien
			System.out.print("Nhap ma nhan vien : ");
			code = sc.nextLine();
			System.out.println("");
			
			hashNV.put("code",code);
			
			//--Ten nhan vien
			System.out.print("Nhap ten nhan vien : ");
			name = sc.nextLine();
			System.out.println("");
			
			hashNV.put("name",name);
			
			//--Tuoi nhan vien
			Scanner sc1 = new Scanner(System.in);
			System.out.print("Nhap tuoi nhan vien : ");
			age = sc1.nextInt();
			System.out.println("");
			
			hashNV.put("age",age);
			
			//--Gioi tinh nhan vien
			System.out.print("Nhap gioi tinh nhan vien : ");
			genner = sc.nextLine();
			System.out.println("");
			
			hashNV.put("genner",genner);
			
			//--Email nhan vien
			System.out.print("Nhap email nhan vien : ");
			email = sc.nextLine();
			System.out.println("");
			
			hashNV.put("email",email);
			
			//--So dien thoai nhan vien
			System.out.print("Nhap so dien thoai nhan vien : ");
			phone = sc.nextLine();
			System.out.println("");
			
			hashNV.put("phone",phone);
			
			//--Dia chi nhan vien
			System.out.print("Nhap dia chi nhan vien : ");
			address = sc.nextLine();
			System.out.println("");
			
			hashNV.put("address",address);
			
			//Dua thong tin nhan vien vao List nhanvien
			employ.add(hashNV);
			
			//Kiem tra nhap tiep hay dung lai
			System.out.println("Ban muon nhap tiep hay dung lai ( C : Continuous, S : Stop) : ");
			String check = sc.nextLine();
			
			while(!(check.equalsIgnoreCase("C") ||  check.equalsIgnoreCase("S") )) {
				System.out.println("--Note : Khong co chuc nang nay, ban vui long chon lai : ");
				check = sc.nextLine();
			}
			
			if(check.equalsIgnoreCase("S")) {
				break;
			}else {
				count++;
			}
			
		}
	}
	
}
