package apr.annottations.customannotation;

@CustomAnnotationForClass(date = "2016-01-01")
public class AnnotatedClass {

	@CustomAnnotationForMethod(date = "2016-01-01", description = "annotated method")
	public String annotatedMethod() {
		return "nothing niente";
	}

	@CustomAnnotationForMethod(author = "friend of mine", date = "2016-01-01", description = "annotated method")
	public String annotatedMethodFromAFriend() {
		return "nothing niente";
	}

}
