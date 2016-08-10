package table.affair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import database.DatabaseFactory;

public class AffairHandle {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	/**
	 * ���ɴ���� Ψһ id
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
	 * ��ô洢��Ŀ������
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
	 * �������ݿ�
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
	    	//insert into affair values(5,'�質����','�質������Ҫ�����ˡ�������','1470204668573',2)
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
	 * ɾ��ָ��id���ֶ�
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
	 * �õ�ָ�� sortId������
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
	    	stmt = con.createStatement();//����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��󡣴���һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
	    	String str = "select * from affair where sortId = '"+sortId+"'";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //���ж�ȡ
				s = new Affair();
				s.setSortId(rs.getInt("sortId")); //��ȡ ָ������ ���ֶ�ֵ��ע���ȡ����ֵ���� Ҫ�� ���ݿ�Ĵ������ һ�£���
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
	 * �õ����е�����
	 * @return
	 */
	public List<Affair> getAffairs(){
		List<Affair> list = new ArrayList<Affair>();
		Affair s ;	    
	    try {
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    	return null;
		    }
	    	stmt = con.createStatement();//����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��󡣴���һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
	    	String str = "select * from affair";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //���ж�ȡ
				s = new Affair();
				s.setSortId(rs.getInt("sortId")); //��ȡ ָ������ ���ֶ�ֵ��ע���ȡ����ֵ���� Ҫ�� ���ݿ�Ĵ������ һ�£���
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
	 * ͨ��affairId ��� Affair����
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
	    	stmt = con.createStatement();//����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��󡣴���һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
	    	String str = "select * from affair where affairId = '"+affairId+"'";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //���ж�ȡ
				s = new Affair();
				s.setSortId(rs.getInt("sortId")); //��ȡ ָ������ ���ֶ�ֵ��ע���ȡ����ֵ���� Ҫ�� ���ݿ�Ĵ������ һ�£���
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
	 * ����ɾ���� ����ţ�����������������
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
				a.setSortId(rs.getInt("sortId")); //��ȡ ָ������ ���ֶ�ֵ��ע���ȡ����ֵ���� Ҫ�� ���ݿ�Ĵ������ һ�£���
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
		Calendar calendar = Calendar.getInstance(); 
		List<String> list = new ArrayList<String>();
		HashSet<String> hs = null;
		try {
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    	return null;
		    }
	    	stmt = con.createStatement();//����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��󡣴���һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
	    	String str = "select * from affair";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //���ж�ȡ
		        calendar.setTimeInMillis(rs.getLong("fbTime"));
		        int year = calendar.get(Calendar.YEAR);
				list.add(String.valueOf(year));
				hs = new HashSet<String>(list);
				list = new ArrayList<String>(hs);
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
	
	public List<Affair> queryByTime(String year,Integer month){
		Calendar ca = Calendar.getInstance();
		Calendar ca2 = Calendar.getInstance();
		String str = null;
		long time1 = 0;
		long time2 = 0;		
		switch (month) {
		case 0:
			ca.set(Integer.valueOf(year), 0, 1);
			ca2.set(Integer.valueOf(year), 11, 30);
			time2 = ca2.getTimeInMillis();
			time1 = ca.getTimeInMillis();
			str = "select * from affair where fbTime>='"+time1+"' And fbTime<'"+time2+"'" ;
//			str = "select * from affair where fbTime between'"+time1+"' And '"+time2+"'" ;
			
			break;
		case 1:
			ca.set(Integer.valueOf(year), 0, 1);
			ca2.set(Integer.valueOf(year), 6, 1);
			time1 = ca.getTimeInMillis();
			time2 = ca2.getTimeInMillis();
			str = "select * from affair where fbTime>='"+time1+"' And fbTime<'"+time2+"'";
//			str = "select * from affair where fbTime between'"+time1+"' And '"+time2+"'" ;
			
			break;
		case 2:
			ca.set(Integer.valueOf(year), 6, 1);
			ca2.set(Integer.valueOf(year), 11, 1);
			time1 = ca.getTimeInMillis();
			time2 = ca2.getTimeInMillis();
			str = "select * from affair where fbTime>='"+time1+"' And fbTime<'"+time2+"'";
//			str = "select * from affair where fbTime between'"+time1+"' And '"+time2+"'" ;
			
			break;
		}
		if(year == null||month==null){
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
			
			rs = stmt.executeQuery(str);
			while(rs.next()){
				a = new Affair();
				a.setSortId(rs.getInt("sortId")); //��ȡ ָ������ ���ֶ�ֵ��ע���ȡ����ֵ���� Ҫ�� ���ݿ�Ĵ������ һ�£���
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

}
