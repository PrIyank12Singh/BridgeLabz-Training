import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)  // Needed for runtime reflection
@Target(ElementType.METHOD)          // can be applied to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}
