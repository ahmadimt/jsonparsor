/**
 * 
 */
package com.imti.dynamic.json.annotattion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

/**
 * @author imteyaza
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface SkipWrapperObject {
	String value();
}
