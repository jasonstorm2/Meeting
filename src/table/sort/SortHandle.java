package table.sort;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseFactory;

public class SortHandle {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	/**
	 * 得到 sort 表的所有信息，以list"<"sort>"封装
	 * @return
	 */
	public List<Sort> getSorts(){
		List<Sort> list = new ArrayList<Sort>();
		Sort s ;
	    
	    try {
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    	return null;
		    }
	    	stmt = con.createStatement();//用于执行静态 SQL 语句并返回它所生成结果的对象。创建一个 Statement 对象来将 SQL 语句发送到数据库。
	    	String str = "select * from sort";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //逐行读取
				s = new Sort();
				s.setSortId(rs.getInt("sortId")); //读取 指定名称 的字段值。注意读取的数值类型 要与 数据库的存放类型 一致！！
				s.setName(rs.getString("name"));
				list.add(s);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		return list;
	}
	
	public Sort getSortInfo(int sortId){
		Sort s = null;
	    try {
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    	return null;
		    }
	    	stmt = con.createStatement();//用于执行静态 SQL 语句并返回它所生成结果的对象。创建一个 Statement 对象来将 SQL 语句发送到数据库。
	    	String str = "select * from sort where sortId = '"+sortId+"'";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //逐行读取
				s = new Sort();
				s.setSortId(rs.getInt("sortId")); //读取 指定名称 的字段值。注意读取的数值类型 要与 数据库的存放类型 一致！！
				s.setName(rs.getString("name"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		return s;
	}

}
