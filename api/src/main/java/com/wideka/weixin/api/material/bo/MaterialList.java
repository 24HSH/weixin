package com.wideka.weixin.api.material.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wideka.weixin.framework.bo.Result;

/**
 * 
 * @author JiakunXu
 * 
 */
public class MaterialList extends Result {

	private static final long serialVersionUID = 8899125312349568509L;

	/**
	 * 素材类型，可以为图文(mpnews)、图片（image）、音频（voice）、视频（video）、文件（file）.
	 */
	@JSONField(name = "type")
	private String type;

	/**
	 * 应用该类型素材总数目.
	 */
	@JSONField(name = "total_count")
	private int totalCount;

	/**
	 * 返回该类型素材数目.
	 */
	@JSONField(name = "item_count")
	private int itemCount;

	/**
	 * 返回该类型素材列表.
	 */
	@JSONField(name = "itemlist")
	private List<Material> materialList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

}
