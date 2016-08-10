package table.affair;

import java.sql.Date;



public class Affair {
	Integer affairId;
	String title;
	String content;
	long  fbTime;
	Integer sortId;
	public Integer getAffairId() {
		return affairId;
	}
	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getFbTime() {
		return fbTime;
	}
	public void setFbTime(long fbTime) {
		this.fbTime = fbTime;
	}
	public Integer getSortId() {
		return sortId;
	}
	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

}
