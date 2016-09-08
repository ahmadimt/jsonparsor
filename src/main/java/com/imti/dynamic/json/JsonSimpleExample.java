/**
 * 
 */
package com.imti.dynamic.json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.io.Resources;

/**
 * @author imteyaza
 *
 */
public class JsonSimpleExample {

	public static void main(String[] args) throws IOException, ParseException {
		getKeys();
	}

	public static void getKeys() throws IOException, ParseException {
		String data = Resources.toString(Resources.getResource("data_details.json"), StandardCharsets.UTF_8);
		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(data);

		JSONObject jsonObject = (JSONObject) parse;
		@SuppressWarnings("rawtypes")
		Iterator iterator = jsonObject.keySet().iterator();
		while (iterator.hasNext()) {
			String next = (String) iterator.next();
			String value = jsonObject.get(next).toString();
			System.out.println(next);
			System.out.println(value);
		}

	}
}
