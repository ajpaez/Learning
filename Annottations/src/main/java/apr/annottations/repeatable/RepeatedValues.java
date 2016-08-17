package apr.annottations.repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Container for the {@link CanBeRepeated} Annotation containing a list of
 * values. anotación que se va a repetir o que se puede repetir
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface RepeatedValues {
	CanBeRepeated[] value();
}
