/**
 * 
 */
package com.imti.dynamic.json

import static groovy.json.JsonParserType.LAX as RELAX
import groovy.json.JsonSlurper

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

/**
 * @author imteyaza
 *
 */
class JsonSluporExample {

	static void readJson(){
		def data = Resources.toString(Resources.getResource("data_details.json"), StandardCharsets.UTF_8)
		def jsonReader = new JsonSlurper()
		def object = jsonReader.setType(RELAX).parseText(data)
		assert object instanceof Map
		println object.Header.Time
		assert object.Header.Time == "2016-08-09T08:57:11-07:00"
	}

	public static void main(String [] args){
		readJson()
	}
}
