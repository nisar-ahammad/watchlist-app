package com.WatchListApp.ModelLayer.Validation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingAnnotationLogic.class)
public @interface Rating {
	
	String message() default "Pls enter value between 5.0 and 10.0";
	Class<?> [] groups() default{};
	Class<? extends Payload>[] payload() default{};

}
