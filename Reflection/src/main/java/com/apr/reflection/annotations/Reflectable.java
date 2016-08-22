package com.apr.reflection.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// method and types are needed in this case
@Target({ ElementType.TYPE_USE, ElementType.METHOD })
public @interface Reflectable {
	public String author() default "author";

	String getInfo() default "Info";
}
