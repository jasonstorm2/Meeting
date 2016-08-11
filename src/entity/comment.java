package entity;

import org.gof.core.gen.entity.Column;
import org.gof.core.gen.entity.Entity;

@Entity(entityName = "comment", tableName = "comment")
public enum comment {
	@Column(type = int.class,index = true,comment = "评论id")
	commentId,
	@Column(type = String.class, length = 300, comment = "评论内容")
	content,
	@Column(type = long.class,comment = "评论时间")
	plTime,
	@Column(type = String.class,length = 64,comment = "作者")
	author,
	@Column(type = int.class, comment = "事务号")
	affairId,	
}
