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
public class Header {

	@JsonProperty("ColData")
	private List<ColData> colDatas = new ArrayList<>();

	public List<ColData> getColDatas() {
		return colDatas;
	}

	public void setColDatas(List<ColData> colDatas) {
		this.colDatas = colDatas;
	}

	@Override
	public String toString() {
		return "Header [colDatas=" + colDatas + "]";
	}

}
