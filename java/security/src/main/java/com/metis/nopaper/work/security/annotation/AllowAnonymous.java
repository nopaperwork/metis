package com.metis.nopaper.work.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.metis.nopaper.work.security.enums.ValidationType;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowAnonymous {

	ValidationType validationType() default ValidationType.ANONYMOUS;

}
