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
	 * �õ� sort ���������Ϣ����list"<"sort>"��װ
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
	    	stmt = con.createStatement();//����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��󡣴���һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
	    	String str = "select * from sort";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //���ж�ȡ
				s = new Sort();
				s.setSortId(rs.getInt("sortId")); //��ȡ ָ������ ���ֶ�ֵ��ע���ȡ����ֵ���� Ҫ�� ���ݿ�Ĵ������ һ�£���
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
	    	stmt = con.createStatement();//����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��󡣴���һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
	    	String str = "select * from sort where sortId = '"+sortId+"'";	
			rs = stmt.executeQuery(str);	
			
			while(rs.next()){ //���ж�ȡ
				s = new Sort();
				s.setSortId(rs.getInt("sortId")); //��ȡ ָ������ ���ֶ�ֵ��ע���ȡ����ֵ���� Ҫ�� ���ݿ�Ĵ������ һ�£���
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
