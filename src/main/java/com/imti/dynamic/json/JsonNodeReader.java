/**
 * 
 */
package com.imti.dynamic.json;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

/**
 * @author imteyaza
 *
 */
public class JsonNodeReader {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	public static void main(String[] args) throws JsonProcessingException, IOException {
		String data = Resources.toString(Resources.getResource("data.json"), StandardCharsets.UTF_8);
		List<String> keys = getKeys("src/main/resources/data.json");

		Rows rows = getRows("src/main/resources/data.json");

		List<Row> rowList = rows.getRows();
		rowList.stream().filter(Objects::nonNull).forEach(object -> {
			Header header = object.getHeader();
			if (Objects.nonNull(header)) {
				List<ColData> colDatas = header.getColDatas();
				colDatas.stream().filter(Objects::nonNull).forEach(innerObject -> {
					//System.out.print(innerObject.getValue());
					//System.out.print(innerObject.getId());
				});
			}
			List<Data> datas = object.getSummary().getDatas();
			datas.stream().filter(Objects::nonNull).forEach(objectData -> {
				System.out.print(objectData.getValue()+" ");
			});
		});

		keys.stream().filter(Objects::nonNull).forEach(key -> {
			if (key.equalsIgnoreCase("Columns")) {
				JsonNode readTree = null;
				JsonNode jsonNode = null;
				ObjectMapper mapper = new ObjectMapper();
				try {
					readTree = mapper.readTree(data);
					jsonNode = readTree.path(key).get("Column");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {

					Column[] columns = mapper.readValue(jsonNode.toString(), Column[].class);
					// List<ColumnWrapper> wrappers =
					// columnMapper.getColumnWrappers();

					for (Column column : columns) {
						//System.out.println(column);
					}

				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public static List<String> getKeys(String filePath) throws JsonProcessingException, IOException {

		JsonFactory factory = new MappingJsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		List<String> keys = new ArrayList<>();

		JsonNode jsonNode = mapper.readTree(new File(filePath));
		Iterator<Entry<String, JsonNode>> fields = jsonNode.fields();
		while (fields.hasNext()) {
			Map.Entry<String, JsonNode> field = fields.next();
			keys.add(field.getKey());

			// if (field.getKey().equalsIgnoreCase("Rows")) {
			// System.out.println("Key: " + field.getKey() + "\tValue:" +
			// field.getValue());
			// Rows rows = mapper.readValue(field.getValue().toString(),
			// Rows.class);
			// System.out.println(rows.toString());
			// }
		}
		return keys;
	}

	public static Rows getRows(String filePath) throws JsonProcessingException, IOException {

		JsonFactory factory = new MappingJsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		List<String> keys = new ArrayList<>();
		Rows rows = new Rows();
		JsonNode jsonNode = mapper.readTree(new File(filePath));
		Iterator<Entry<String, JsonNode>> fields = jsonNode.fields();
		while (fields.hasNext()) {
			Map.Entry<String, JsonNode> field = fields.next();
			keys.add(field.getKey());

			if (field.getKey().equalsIgnoreCase("Rows")) {
				// System.out.println("Key: " + field.getKey() + "\tValue:" +
				// field.getValue());
				rows = mapper.readValue(field.getValue().toString(), Rows.class);
				// System.out.println(rows.toString());
			}
		}
		return rows;
	}
}
