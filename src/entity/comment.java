package entity;

import org.gof.core.gen.entity.Column;
import org.gof.core.gen.entity.Entity;

@Entity(entityName = "comment", tableName = "comment")
public enum comment {
	@Column(type = int.class,index = true,comment = "����id")
	commentId,
	@Column(type = String.class, length = 300, comment = "��������")
	content,
	@Column(type = long.class,comment = "����ʱ��")
	plTime,
	@Column(type = String.class,length = 64,comment = "����")
	author,
	@Column(type = int.class, comment = "�����")
	affairId,	
}
