/**
 * 
 */
package com.imti.dynamic.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author imteyaza
 *
 */
public class MetaData {

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Value")
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MetaData [name=" + name + ", value=" + value + "]";
	}

}
