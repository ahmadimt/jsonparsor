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
public class Rows {

	@JsonProperty("Row")
	private List<Row> rows = new ArrayList<>();

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Rows [rows=" + rows + "]";
	}

}
