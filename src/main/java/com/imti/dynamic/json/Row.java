package com.imti.dynamic.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author imteyaza
 *
 */
public class Row {

	@JsonProperty("Header")
	private Header header;

	@JsonProperty("Rows")
	private InnerRows innerRows;

	@JsonProperty("Summary")
	private Summary summary;

	private String type;

	private String group;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public InnerRows getInnerRows() {
		return innerRows;
	}

	public void setInnerRows(InnerRows innerRows) {
		this.innerRows = innerRows;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Row [header=" + header + ", innerRows=" + innerRows + ", summary=" + summary + ", type=" + type
				+ ", group=" + group + "]";
	}

}
