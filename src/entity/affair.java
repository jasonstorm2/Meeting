package entity;

import org.gof.core.gen.entity.Column;
import org.gof.core.gen.entity.Entity;

@Entity(entityName = "affair", tableName = "affair")
public enum affair {
	@Column(type = int.class,index = true,comment = "事务号")
	affairId,
	@Column(type = String.class, length = 64, comment = "事务标题")
	title,
	@Column(type = String.class, length = 300, comment = "事务内容")
	content,
	@Column(type = long.class,comment = "发布时间")
	fbTime,
	@Column(type = int.class, comment = "事务类别号")
	sortId,	
}
