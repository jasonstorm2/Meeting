package table.affair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import table.sort.Sort;
import database.DatabaseFactory;

public class AffairHandle {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	/**
	 * ������ ���ݱ� �м�����¼
	 * @return
	 */
	public int recordCount(){
		int num=0;
		try{
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    }
	    	stmt = con.createStatement();//����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��󡣴���һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
	    	String str = "select * from affair";  	
			rs = stmt.executeQuery(str);		
			while(rs.next()){ //���ж�ȡ
				num++;				
			}
		}catch(Exception e){e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return num;
		
	}
	
	public boolean save(Affair affair){
		boolean boo = false;
		int num = affair.getAffairId();
		String title = affair.getTitle();
		String content = affair.getContent();
		long fbTime = affair.getFbTime();
		int sortId = affair.getSortId();
		try{
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    	return false;
		    }
	    	stmt = con.createStatement();//����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��󡣴���һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
	    	String str = "insert into affair values(";
	    	str+=num+",'"+title+"','"+content+"','"+fbTime+"',"+sortId+")";
			stmt.executeUpdate(str);
			boo = true;
			
		}catch(Exception e){e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return boo;
	}

}
