/**
 * 
 */
package com.imti.dynamic.json.annotattion;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author imteyaza
 *
 */
public class SkipWrapperObjectDeserializer extends JsonDeserializer<Object> implements
ContextualDeserializer {

	private Class<?> wrappedType;
	private String wrapperKey;

	public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
			throws JsonMappingException {
		SkipWrapperObject skipWrapperObject = property.getAnnotation(SkipWrapperObject.class);
		wrapperKey = skipWrapperObject.value();
		JavaType collectionType = property.getType();
		JavaType collectedType = collectionType.containedType(0);
		wrappedType = collectedType.getRawClass();
		return this;
	}

	@Override
	public Object deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.readTree(parser);
		JsonNode wrapped = objectNode.get(wrapperKey);
		Object mapped = mapIntoObject(wrapped);
		return mapped;
	}

	private Object mapIntoObject(JsonNode node) throws IOException, JsonProcessingException {
		JsonParser parser = node.traverse();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(parser, wrappedType);
	}
}
