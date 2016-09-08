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
public class ColumnMapper {

	@JsonProperty("Column")
	public String column;

	private List<ColumnWrapper> columnWrappers = new ArrayList<>();

	public List<ColumnWrapper> getColumnWrappers() {
		return columnWrappers;
	}

	public void setColumnWrappers(List<ColumnWrapper> columnWrappers) {
		this.columnWrappers = columnWrappers;
	}

}
