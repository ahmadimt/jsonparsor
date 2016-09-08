package com.imti.dynamic.json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

import org.jsfr.json.JsonPathListener;
import org.jsfr.json.JsonSurfer;
import org.jsfr.json.ParsingContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.io.Resources;

/**
 * Created by imteyaza on 8/8/16.
 */
public class JsonParsorMain {

	public static void main(String[] args) throws IOException {
		String data = Resources.toString(Resources.getResource("data_details.json"), StandardCharsets.UTF_8);
		JsonSurfer surfer = JsonSurfer.jackson();
		List<String> keys = JsonNodeReader.getKeys("src/main/resources/data_details.json");
		// Collection<Object> multipleResults = surfer.collectAll(data,
		// "$.Rows.Row[*]");
		// Iterator<Object> iterator = multipleResults.iterator();
		/*
		 * while (iterator.hasNext()) { System.out.println(iterator.next()); }
		 */
		keys.stream().filter(Objects::nonNull).forEach(key -> {
			System.out.println(key);
			surfer.configBuilder().bind("$.." + key, new JsonPathListener() {
				@Override
				public void onValue(Object value, ParsingContext context)
						throws JsonParseException, JsonMappingException, IOException {
					System.out.println(value);
					// ObjectMapper objectMapper = new ObjectMapper();
					// ObjectMapper readTree =
					// objectMapper.readValue(value.toString(),
					// ObjectMapper.class);
					// List<Column> columns =
					// Arrays.asList(objectMapper.readValue(value.toString(),
					// Column.class));
					/*
					 * for (Column key : columns.getColumn()) {
					 * System.out.println(key); }
					 */

				}
			}).buildAndSurf(data);
		});

	}
}
