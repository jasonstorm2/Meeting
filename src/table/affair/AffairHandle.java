package table.affair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseFactory;

public class AffairHandle {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	/**
	 * 生成储存的 唯一 id
	 * @return
	 */
	public int recordCount() {
		int num = 0;
		try {
			con = DatabaseFactory.connectDatabase();
			if (con == null) {
				return -1;
			}
			stmt = con.createStatement();
			String str2 = "select max(affairId) from affair limit 0,1";
			rs = stmt.executeQuery(str2);
			int rows = rs.getRow();
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	
	/**
	 * 获得存储条目的数量
	 * @return
	 */
	public int getCount(){
		int num=0;
		try{
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    }
	    	stmt = con.createStatement();
	    	String str = "select * from affair";  	
			rs = stmt.executeQuery(str);		
			while(rs.next()){ 
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
	
	/**
	 * 保存数据库
	 * @param affair
	 * @return
	 */
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
	    	stmt = con.createStatement();
	    	String str = "insert into affair values(";
	    	str+=num+",'"+title+"','"+content+"','"+fbTime+"',"+sortId+")";
	    	//insert into affair values(5,'歌唱比赛','歌唱比赛快要举行了。。。。','1470204668573',2)
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
	
	public boolean update(Affair a){
		boolean re = false;
		int affairId = a.getAffairId();
		String title = a.getTitle();
		String content = a.getContent();
		long time = a.getFbTime();
		int sortId = a.getSortId();
		
		con = DatabaseFactory.connectDatabase();
		if(con == null){
			return false;
		}
		try {
			stmt = con.createStatement();
			String str = "update affair set title='"+title+"'"+",content='"
			+content+"'"+",fbTime='"+time+"'"+",sortId='"+sortId+"' where affairId = '"+affairId+"'";
			stmt.executeUpdate(str);
			re = true;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return re;
	}	
	/**
	 * 删除指定id的字段
	 * @param affairId
	 * @return
	 */
	public boolean delete(int affairId){
		boolean re = false;
		con = DatabaseFactory.connectDatabase();
		if(con==null){
	    	return false;
	    }
		try {
			stmt = con.createStatement();
			String str = "delete from affair where affairId = '"+affairId+"'";
			stmt.executeUpdate(str);			
			re = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}		
		return re;		
	}
	/**
	 * 得到指定 sortId的事务
	 * @param sortId
	 * @return
	 */
	public List<Affair> affairsList(int sortId){
		List<Affair> list = new ArrayList<Affair>();
		Affair s ;
	    
	    try {
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    	return null;
		    }
	    	stmt = con.createStatement();//用于执行静态 SQL 语句并返回它所生成结果的对象。创建一个 Statement 对象来将 SQL 语句发送到数据库。
	    	String str = "select * from affair where sortId = '"+sortId+"'";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //逐行读取
				s = new Affair();
				s.setSortId(rs.getInt("sortId")); //读取 指定名称 的字段值。注意读取的数值类型 要与 数据库的存放类型 一致！！
				s.setAffairId(rs.getInt("affairId"));
				s.setContent(rs.getString("content"));
				s.setTitle(rs.getString("title"));
				s.setFbTime(rs.getLong("fbTime"));
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
	
	/**
	 * 通过affairId 获得 Affair对象
	 * @param affairId
	 * @return
	 */
	public Affair getAffairById(int affairId){
		Affair s =null;	    
	    try {
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    	return null;
		    }
	    	stmt = con.createStatement();//用于执行静态 SQL 语句并返回它所生成结果的对象。创建一个 Statement 对象来将 SQL 语句发送到数据库。
	    	String str = "select * from affair where affairId = '"+affairId+"'";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //逐行读取
				s = new Affair();
				s.setSortId(rs.getInt("sortId")); //读取 指定名称 的字段值。注意读取的数值类型 要与 数据库的存放类型 一致！！
				s.setAffairId(rs.getInt("affairId"));
				s.setContent(rs.getString("content"));
				s.setTitle(rs.getString("title"));
				s.setFbTime(rs.getLong("fbTime"));
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
	
	/**
	 * 根据删除的 事务号，重新排列事务序列
	 * @param affairId
	 */
	public void reSorting(int affairId) {
		int num = getCount();
		String str;
		try {
			con = DatabaseFactory.connectDatabase();
			for (int i = affairId; i < num; i++) {
				str = "update affair set affairId = '" + i + "' where affairId ='" + affairId + 1 + "'";
				stmt = con.createStatement();
				stmt.executeUpdate(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				con.close();
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}			
		}
	}
	
	public List<Affair> queryByTitle(String key){
		if(key == null){
			return null;
		}
		List<Affair> list = new ArrayList<Affair>();
		Affair a = null;
		try {
			con = DatabaseFactory.connectDatabase();
			if(con ==null){
				return null;
			}
			stmt = con.createStatement();
			String str = "select * from affair where title like '%"+key+"%'";
			rs = stmt.executeQuery(str);
			while(rs.next()){
				a = new Affair();
				a.setSortId(rs.getInt("sortId")); //读取 指定名称 的字段值。注意读取的数值类型 要与 数据库的存放类型 一致！！
				a.setAffairId(rs.getInt("affairId"));
				a.setContent(rs.getString("content"));
				a.setTitle(rs.getString("title"));
				a.setFbTime(rs.getLong("fbTime"));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	public List<String> getYears(){
		return null;
	}
	
	public List<Affair> queryByTime(String year,String month){
		return null;
	}

}
