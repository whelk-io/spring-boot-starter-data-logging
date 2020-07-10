package io.whelk.spring.data.logging.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.boot.logging.LogLevel;

public interface Log {

    public interface Trace {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            boolean withStacktrace() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
            boolean withStacktrace() default true;
        }

    }

    public interface Debug {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            boolean withStacktrace() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
            boolean withStacktrace() default true;
        }

    }

    public interface Info {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            boolean withStacktrace() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
            boolean withStacktrace() default true;
        }

    }

    public interface Warn {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            boolean withStacktrace() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
            boolean withStacktrace() default true;
        }

    }

    public interface Error {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            boolean withStacktrace() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
            boolean withStacktrace() default true;
        }

    }

    public interface Fatal {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {

        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            boolean withStacktrace() default true;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
            boolean withStacktrace() default true;
        }

    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Before {
        boolean withArgs() default true;
        LogLevel withLevel() default LogLevel.DEBUG;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface After {
        LogLevel withLevel() default LogLevel.DEBUG;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterReturning {
        LogLevel withLevel() default LogLevel.DEBUG;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterThrowing {
        LogLevel withLevel() default LogLevel.ERROR;
        boolean withStacktrace() default true;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Around {
        boolean withArgs() default true;
        boolean withReturnType() default true;
        LogLevel withLevel() default LogLevel.DEBUG;
        boolean withStacktrace() default true;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Span {
    }

}
