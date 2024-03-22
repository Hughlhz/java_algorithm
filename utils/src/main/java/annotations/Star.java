package annotations;

import com.sun.jdi.Value;

import java.lang.annotation.Target;

public @interface Star {
    String value() default "有价值！";
}
