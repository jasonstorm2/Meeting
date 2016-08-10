package table.comment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseFactory;
import table.affair.Affair;

public class CommentHandle {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	/**
	 * 删除相关 affairId 的评论
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
			String str = "delete from comment where affairId = '"+affairId+"'";
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
	
	public ArrayList<Comment> getCommentByAffairId(int affairId){
		Comment com = null;
		ArrayList<Comment> list = new ArrayList<Comment>();
		boolean re = false;
		try {
			con = DatabaseFactory.connectDatabase();
			if(con==null){
		    	return null;
		    }
			stmt = con.createStatement();
			String str = "select * from comment where affairId = '"+affairId+"'";
			rs = stmt.executeQuery(str);
			while(rs.next()){
				com = new Comment();
				com.setAffairId(affairId); 
				com.setAuthor(rs.getString("author"));
				com.setCommentId(rs.getInt("commentId"));
				com.setContent(rs.getString("content"));
				com.setPlTime(rs.getLong("plTime"));
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;		
	}
	
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
			String str2 = "select max(commentId) from comment limit 0,1";
			rs = stmt.executeQuery(str2);
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
		return num+1;
	}
	
	/**
	 * 保存数据库
	 * @param affair
	 * @return
	 */
	public boolean save(Comment comment){
		boolean boo = false;
		int num = comment.getCommentId();
		String content = comment.getContent();
		long fbTime = System.currentTimeMillis();
		String author = comment.getAuthor();
		int affairId = comment.getAffairId();
		
		
		try{
	    	con = DatabaseFactory.connectDatabase();
		    if(con==null){
		    	return false;
		    }
	    	stmt = con.createStatement();
	    	String str = "insert into comment values(";
	    	str+=num+",'"+content+"',"+fbTime+",'"+author+"',"+affairId+")";
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

}
