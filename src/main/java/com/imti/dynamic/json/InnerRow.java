/**
 * 
 */
package com.imti.dynamic.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author imteyaza
 *
 */
public class InnerRow {

	@JsonProperty("ColData")
	private List<ColData> colDatas = new ArrayList<>();

	private String type;

	public List<ColData> getColDatas() {
		return colDatas;
	}

	public void setColDatas(List<ColData> colDatas) {
		this.colDatas = colDatas;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "InnerRows [colDatas=" + colDatas + ", type=" + type + "]";
	}

}
