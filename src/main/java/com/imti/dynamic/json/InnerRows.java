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
public class InnerRows {

	@JsonProperty("Row")
	private List<InnerRow> innerRows = new ArrayList<>();

	public List<InnerRow> getInnerRows() {
		return innerRows;
	}

	public void setInnerRows(List<InnerRow> innerRows) {
		this.innerRows = innerRows;
	}

	@Override
	public String toString() {
		return "InnerRows [innerRows=" + innerRows + "]";
	}

}
