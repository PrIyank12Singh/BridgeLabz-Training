import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)  // Needed at runtime
@Target(ElementType.FIELD)            // Can be applied to fields
@interface MaxLength {
    int value();                      // Max allowed length
}
