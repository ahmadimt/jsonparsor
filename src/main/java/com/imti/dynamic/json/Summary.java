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
public class Summary {

	@JsonProperty("ColData")
	private List<Data> datas = new ArrayList<>();

	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Summary [datas=" + datas + "]";
	}

}
