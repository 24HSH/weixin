package com.wideka.weixin.api.department.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Department extends Result {

	private static final long serialVersionUID = -5626022927247301256L;

	/**
	 * 部门id.
	 */
	@JSONField(name = "id")
	private int id;

	/**
	 * 部门名称.
	 */
	@JSONField(name = "name")
	private String name;

	/**
	 * 父部门id.
	 */
	@JSONField(name = "parentid")
	private int parentId;

	/**
	 * 是否具有该部门的写权限.
	 */
	@JSONField(name = "writable")
	private String writable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getWritable() {
		return writable;
	}

	public void setWritable(String writable) {
		this.writable = writable;
	}

}
