package apr.annottations.repeatable;

@CannotBeRepeated("info")
/*
 * if we try repeat the annotation we will get an error: Duplicate annotation of
 * non-repeatable type
 * 
 * @CannotBeRepeated. Only annotation types marked
 * 
 * @Repeatable can be used multiple times at one target.
 */

// --> @CannotBeRepeated("more info")
public class RepeatableAnnotatedWrong {

}
