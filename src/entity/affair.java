package entity;

import org.gof.core.gen.entity.Column;
import org.gof.core.gen.entity.Entity;

@Entity(entityName = "affair", tableName = "affair")
public enum affair {
	@Column(type = int.class,index = true,comment = "�����")
	affairId,
	@Column(type = String.class, length = 64, comment = "�������")
	title,
	@Column(type = String.class, length = 300, comment = "��������")
	content,
	@Column(type = long.class,comment = "����ʱ��")
	fbTime,
	@Column(type = int.class, comment = "��������")
	sortId,	
}
