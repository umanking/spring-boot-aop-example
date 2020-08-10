package com.example.demo.aspect.annotation;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.CLASS)
@Target(value = ElementType.METHOD)
public @interface LogExecutionTime {
}
