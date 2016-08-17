package apr.annottations.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target {@link ElementType} Type indicates the context where the annotation
 * takes place, in this case class scope
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAnnotationForClass {

	public String author()

	default "author default";

	public String date();

	String getInfo() default "Info";

}
