package annotations;

import com.sun.jdi.Value;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
public @interface Star {
    String value() default "有价值！";
}
