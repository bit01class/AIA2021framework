package com.bit.util;

import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Documented
@Retention(CLASS)
public @interface Bit {
	String value() default "";
	String[] arr();
}
