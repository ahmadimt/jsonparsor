/**
 * 
 */
package com.imti.dynamic.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author imteyaza
 *
 */
public class ColData extends Data {

	@JsonProperty("id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ColData [id=" + id + "]";
	}

}
