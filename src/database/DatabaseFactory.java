package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseFactory {
	
	
	public static Connection connectDatabase(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/user_login?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			System.out.println("�ɹ�����������");			
			con = DriverManager.getConnection(url,"root","root");
			System.out.println("�ɹ��������ݿ⣡");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("���ݿ����ʧ�ܣ�����");
		}		
		return con;		
	}

}
