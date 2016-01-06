package com.wideka.weixin.api.department.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class DepartmentObject extends Result {

	private static final long serialVersionUID = -6776792375227747528L;

	/**
	 * 部门列表数据。以部门的order字段从小到大排列.
	 */
	@JSONField(name = "department")
	private List<Department> departmentList;

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

}
