/**
 * 
 */
package com.imti.dynamic.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author imteyaza
 *
 */
public class Column {

	@JsonProperty("ColTitle")
	private String colTitle;

	@JsonProperty("ColType")
	private String colType;

	@JsonProperty("MetaData")
	private List<MetaData> datas;

	public String getColTitle() {
		return colTitle;
	}

	public void setColTitle(String colTitle) {
		this.colTitle = colTitle;
	}

	public String getColType() {
		return colType;
	}

	public void setColType(String colType) {
		this.colType = colType;
	}

	public List<MetaData> getDatas() {
		return datas;
	}

	public void setDatas(List<MetaData> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Column [colTitle=" + colTitle + ", colType=" + colType + ", datas=" + datas + "]";
	}

}
