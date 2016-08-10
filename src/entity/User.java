package entity;

import org.gof.core.gen.entity.Column;
import org.gof.core.gen.entity.Entity;

@Entity(entityName = "user", tableName = "user")
public enum User {
	@Column(type = int.class,index = true, comment = "���")
	number, 
	@Column(type = String.class, length = 64, comment = "�ǳ�")
	userName,
	@Column(type = String.class, length = 64, comment = "�û�����")
	userNameTrue,
	@Column(type = String.class, length = 64, comment = "����")
	userPassword,
	@Column(type = boolean.class,comment = "�Ա�")
	gender,
	@Column(type = String.class, length = 64, comment = "����")
	email,
	@Column(type = String.class, length = 64, comment = "��ַ")
	address,
}
