package entity;

import org.gof.core.gen.entity.Column;
import org.gof.core.gen.entity.Entity;

@Entity(entityName = "sort", tableName = "sort")
public enum sort {
	@Column(type = int.class, index = true,comment = "事务类别号")
	sortId,
	@Column(type = String.class, length = 20, comment = "事务类别名")
	name,
}
