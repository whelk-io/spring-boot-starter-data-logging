package io.whelk.spring.data.logging.sleuth;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public interface Tracer {

    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Span { }

}
