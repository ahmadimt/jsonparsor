/**
 * 
 */
package com.imti.dynamic.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author imteyaza
 *
 */
public class ColumnWrapper {

	@JsonProperty("Column")
	private Column column;

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

}
