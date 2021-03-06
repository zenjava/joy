package org.joy.plugin.security.erbac.model.po;

import org.joy.commons.tree.IListToTreeRestrict;
import org.joy.core.persistence.orm.jpa.annotations.Comment;
import org.joy.core.persistence.support.entity.UuidCrudEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 组id-用户id
 *
 * @since 1.0.0
 * @author Kevice
 * @time 2012-6-21 上午12:13:24
 */
@Entity
@Table(name = "t_erbac_organization")
@Comment("组织机构")
public class TErbacOrganization extends UuidCrudEntity implements IListToTreeRestrict<String> {

	private String parentId; // 父组织id
	private String name; // 组织名称
	private String establishDate; // 成立日期

	@Column(name = "ORG_NAME", length = 64)
	@Comment("名称")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 8)
	@Comment("成立日期")
	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}
	
	@Column(length = 32)
	@Comment("父项ID")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
