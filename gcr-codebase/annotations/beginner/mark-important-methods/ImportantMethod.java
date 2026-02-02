import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // needed to access at runtime
@Target(ElementType.METHOD)           // can only be applied to methods
@interface ImportantMethod {
    String level() default "HIGH";    // optional parameter
}
