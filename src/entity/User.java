package entity;

import org.gof.core.gen.entity.Column;
import org.gof.core.gen.entity.Entity;

@Entity(entityName = "user", tableName = "user")
public enum User {
	@Column(type = int.class,index = true, comment = "编号")
	number, 
	@Column(type = String.class, length = 64, comment = "昵称")
	userName,
	@Column(type = String.class, length = 64, comment = "用户真名")
	userNameTrue,
	@Column(type = String.class, length = 64, comment = "密码")
	userPassword,
	@Column(type = boolean.class,comment = "性别")
	gender,
	@Column(type = String.class, length = 64, comment = "邮箱")
	email,
	@Column(type = String.class, length = 64, comment = "地址")
	address,
}
