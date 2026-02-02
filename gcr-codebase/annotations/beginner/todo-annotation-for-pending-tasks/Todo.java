import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // Needed to access at runtime
@Target(ElementType.METHOD)           // Can be applied to methods
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
