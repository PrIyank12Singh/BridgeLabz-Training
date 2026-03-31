import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@Target(ElementType.FIELD)            // Field-level annotation
@interface JsonField {
    
    String name();                     // Custom JSON key
}
