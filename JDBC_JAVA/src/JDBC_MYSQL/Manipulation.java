package JDBC_MYSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Manipulation implements Manage {
		Connection conn;
		Statement statement;
		
		public Manipulation() {
			ConnectionJDBC connection  = new ConnectionJDBC();
			connection.connect();
			this.conn = connection.conn;
			try {
				statement = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//--INSERT DATA --> DATABASE
		public void add(Employee employee) {
			String sql = "INSERT INTO QuanLyNhanVien(MaNV,TenNV,TuoiNV,GioiTinhNV,SoDienThoaiNV,EmailNV,DiaChiNV) VALUES ("
			+"'"+employee.getCode()+"'"+","+"'"+employee.getName()+"'"+","+"'"+employee.getAge()+"'"+","+"'"+employee.getGenner()+"'"+","
			+"'"+employee.getPhone()+"'"+","+"'"+employee.getEmail()+"'"+","+"'"+employee.getAddress()+"'"+")";
			
			
			try {
				int num = statement.executeUpdate(sql);
				
				if(num != 0) {
					System.out.println("Ban vua them nhan vien "+employee.getCode()+" thanh cong");
				}else {
					System.out.println("--- Error : Co loi khi them nhan vien ---");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//--UPDATE DATA <--> DATABASE
		public void update() {
			while (true) {
			String sql = "UPDATE QuanLyNhanVien SET ";
			String bufferSQL = "";
			
			HashMap modify = new HashMap();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Hay nhap lai thong tin ma ban muon sua doi, thong tin nao khong can thay doi ban co the nhan ENTER de bo qua : ");
			System.out.println("");
			
			System.out.println("MA NHAN VIEN (Neu khong nhap dong nghia ban thay doi cho tat ca nhan vien) = ");
			String code = sc.nextLine();
			
			System.out.print("TEN NHAN VIEN = ");
			String name = sc.nextLine();
			modify.put("TenNV",name);
			System.out.println("");
			
			System.out.print("TUOI NHAN VIEN = ");
			String age = sc.nextLine();
			modify.put("TuoiNV",age);
			System.out.println("");
			
			System.out.print("GIOI TINH NHAN VIEN = ");
			String genner = sc.nextLine();
			modify.put("GioiTinhNV",genner);
			System.out.println("");
			
			System.out.print("EMAIL NHAN VIEN = ");
			String email = sc.nextLine();
			modify.put("EmailNV",email);
			System.out.println("");
			
			System.out.print("SO DIEN THOAI NHAN VIEN = ");
			String phone = sc.nextLine();
			modify.put("SoDienThoaiNV",phone);
			System.out.println("");
			
			System.out.print("DIA CHI NHAN VIEN = ");
			String address = sc.nextLine();
			modify.put("DiaChiNV",address);
			System.out.println("");
			
			//--XU LI UPDATE
			Set modifyKey = modify.keySet();
			
			Iterator iterKey = modifyKey.iterator();
			
			while(iterKey.hasNext()) {
				String key =(String) iterKey.next();
				String value = (String) modify.get(key);
				
				if(!(value == null || value.equals(""))) {
					if(key.equals("TuoiNV")) {
						int valueAge = Integer.valueOf(value);
						bufferSQL += key+"="+valueAge+" ";
					}else {
						bufferSQL += key+"="+"'"+value+"'"+" ";
					}
				}
			}
			
			bufferSQL = bufferSQL.replace(" ",",");
			StringBuilder sbSQL = new StringBuilder(bufferSQL);
			sbSQL.deleteCharAt(sbSQL.length() - 1);
			
			String condition = " WHERE MaNV ="+"'"+code+"'";
			
			sql += sbSQL.toString();
		
			if(!(code == null || code.equals(""))) {
				sql += condition;
			}
			
			try {
				int result = statement.executeUpdate(sql);
				if(result != 0) {
					System.out.println("Ban da thay doi thong tin cua "+code+" thanh cong");
				}else {
					System.out.println("Da xuat hien loi khi thay doi thong tin cua "+code+", vui long kiem tra lai");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("");
			System.out.println("-------------------------------------------------");
			
			//KIEM TRA CO MUON TIEP TUC THAY DOI HAY KHONG ? 
			System.out.println("Ban co muon tiep tuc thuc hien thay doi thong tin khong (Y : Yes, N : No) : ");
			String update = sc.nextLine();
			
			while(!(update.equalsIgnoreCase("Y") || update.equalsIgnoreCase("N"))){
				System.out.println("Chuc nang ban vua chon khong dung, vui long chon lai : ");
				update = sc.nextLine();
			}
			
			System.out.println("-------------------------------------------------");
			if(update.equalsIgnoreCase("N")) {
				System.out.println("Ket thuc thay doi thong tin");
				break;
			}
			}
			
			
		}
		
		//--DELETE DATA-->DATABASE
		public void delete() {
			
			while(true) {
			String sql = "";
			
			System.out.println("Ban muon xoa cau truc hay xoa data (S : Structure, D : Data) : ");
			Scanner sc = new Scanner(System.in);
			String delete = sc.nextLine();
			
			System.out.println("Ban muon xoa bang hay database(D : Database, T: Table) : ");
			String structure = sc.nextLine();
			
			if(structure.equalsIgnoreCase("D")) {
					System.out.println("Vui long nhap ten DATABASE ban muon thuc hien : ");
					String database = sc.nextLine();
					sql = "DROP DATABASE "+database;
			}else if(structure.equalsIgnoreCase("T")) {
				System.out.println("Nhap ten bang ban muon xoa : ");
				String table = sc.nextLine();
				
				
				
				//Xoa cau truc bang
				if(delete.equalsIgnoreCase("S")) {
					sql = "DROP TABLE "+table;
				}
				else if(delete.equalsIgnoreCase("D")) {
				System.out.println("Nhap ma nhan vien ma ban muon xoa(Neu bo qua ban se xoa toan bo bang) :");
				String code = sc.nextLine(); 
					
				if(code.equalsIgnoreCase("") || code == null) {
					sql = "DELETE FROM "+table;
				}else {
					sql = "DELETE FROM "+table+" WHERE MaNV = "+"'"+code+"'";
				}
			}
			}
			
			try {
			
				int result = statement.executeUpdate(sql);
				
				if(result != 0) {
					System.out.println("[Result] : Ban vua thuc hien thao tac xoa thanh cong");
				}else {
					System.out.println("[Error] : Xuat hien loi trong qua trinh xoa");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//KIEM TRA CO MUON TIEP TUC THAY DOI HAY KHONG ? 
			System.out.println("Ban co muon tiep tuc thuc hien xoa thong tin khong (Y : Yes, N : No) : ");
			String update = sc.nextLine();
			
			while(!(update.equalsIgnoreCase("Y") || update.equalsIgnoreCase("N"))){
				System.out.println("Chuc nang ban vua chon khong dung, vui long chon lai : ");
				update = sc.nextLine();
			}
			
			System.out.println("-------------------------------------------------");
			if(update.equalsIgnoreCase("N")) {
				System.out.println("Ket thuc thao tac xoa thong tin");
				break;
			}
		}
			
		}
		
		//--GET DATA <-- DATABASE
		public void get() {
			while(true) {
			String sql = "";
			
			Scanner sc =new Scanner(System.in);
			
			System.out.print("Nhap cac column ma ban muon lay thong tin (Cac column phai ngan cach nhau bang dau phay) : ");
			String col = sc.nextLine();
			System.out.println("");
			
			System.out.print("Nhap ten bang ban muon lay thong tin : ");
			String table = sc.nextLine();
			System.out.println("");
			
			System.out.print("Nhap them dieu kien lay thong tin (Neu can, chi dung dau nhay don, khong dung dau nhay kep) : ");
			String condition = sc.nextLine();
			System.out.println("");
			
			System.out.print("Nhap ten cac cot ma ban muon GROUP(Cac cot ngan cach nhau bang dau phay): ");
			String group = sc.nextLine();
			System.out.println("");
			
			System.out.print("Nhap ten cac cot ma ban muon sap xep : ");
			String order = sc.nextLine();
			System.out.println("");
			
			System.out.print("Ban muon sap xep theo thu tu tang hay giam dan(ASC : Tang dan, DESC : Giam dan) : ");
			String orderSelect = sc.nextLine();
			System.out.println("");
			
			System.out.print("Nhap so luong hang toi da ban muon hien thi : ");
			String limit = sc.nextLine();
			System.out.println("");
			
			sql = "SELECT "+col+" FROM "+table;
			
			if(!(condition == null || condition.equals(""))) {
				sql += " WHERE "+condition;
			}
			
			if(!(group == null || group.equals(""))) {
				sql += " GROUP BY "+group;
			}
			
			if(!(order == null || order.equals(""))) {
				if(!(orderSelect == null || orderSelect.equals(""))) {
					sql += " ORDER BY "+order+" "+orderSelect;
				}else {
					sql += " ORDER BY "+order;
				}
			}
			
			if(!(limit == null || limit.equals(""))) {
				sql += " LIMIT "+limit;
			}
			
			//System.out.println(sql); 
			
			String[] arrCol = col.split(",");
			int len = arrCol.length;
			
			try {
				ResultSet result = statement.executeQuery(sql);
				
				System.out.println("------------KET QUA----------------");
				int count = 0;
				while(result.next()) {
					count++;
					System.out.println("Thong tin nhan vien thu "+count+" :");
					System.out.println("");
					for(int i = 0; i<len; i++) {
						System.out.println(arrCol[i]+" : "+result.getString(arrCol[i].trim()));
					}
					System.out.println("-----------------------------------");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Ban co muon tiep tuc lay thong tin hay khong(Y : Yes, N : No) : ");
			String con = sc.nextLine();
			
			if(con.equalsIgnoreCase("N")) {
				System.out.println("Ket thuc thao tac lay thong tin");
				break;
			}
			System.out.println("----------------------------------");
			}
			
		}
}
