package org.sdrc.boot.web.core;
/**
 * @author Sarita(sarita@sdrc.co.in)
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorize {
	
	public String feature() default "default" ;
	public String permission() default "default" ;

}
