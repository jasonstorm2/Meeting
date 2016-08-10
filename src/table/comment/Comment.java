package table.comment;

import java.sql.Date;

public class Comment {
	Integer commentId;
	String content;
	long plTime;
	String author;
	Integer affairId;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getPlTime() {
		return plTime;
	}
	public void setPlTime(long plTime) {
		this.plTime = plTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getAffairId() {
		return affairId;
	}
	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}

}
