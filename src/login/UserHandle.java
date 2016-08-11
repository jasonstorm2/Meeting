package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseFactory;



public class UserHandle {
	Connection con;
	Statement stmt;
	ResultSet rs;
	

	public User userLogin(User user){
		String userName = user.getUserName();
	    String userPassword = user.getUserPassword();

	    boolean isExact = false;
	    if(userName==null || userPassword==null){
	    	return null;
	    }
	    
	    con = DatabaseFactory.connectDatabase();
	    if(con==null){
	    	return null;
	    }
	    try {
	    	stmt = con.createStatement();
	    	String str = "select * from user where ";
			rs = stmt.executeQuery(str +"userName='"+userName+"' && userPassword = '"+userPassword+"' ");
			
			if(rs.next()){
				if(rs.getString(3)!=null){
					user.setUserNameTrue(rs.getString(3));
				}else{
					user.setUserNameTrue("нч");
				}
				
				if(rs.getString(5)!=null){
					user.setGender(rs.getString(5));
				}else{
					user.setGender("нч");
				}
				
				if(rs.getString(6)!=null){
					user.setEmail(rs.getString(6));
				}else{
					user.setEmail("нч");
				}
				
				if(rs.getString(7)!=null){
					user.setAddress(rs.getString(7));	
				}else{
					user.setAddress("©у");	
				}

				
				if(rs.getString(8)!=null){
					user.setAdmin(rs.getBoolean(8));
				}else{
					user.setAdmin(false);
				}
				isExact = true;
							
			}else{
				user = null;
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		}finally{
			try {
				rs.close();
				if(isExact){
					rs.close();
				}
				stmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				user = null;
			}			
		}	
	     return user;
	}

}
