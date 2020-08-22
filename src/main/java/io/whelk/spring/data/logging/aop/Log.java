package io.whelk.spring.data.logging.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.boot.logging.LogLevel;

import io.whelk.spring.data.logging.writer.ArgWriter;
import io.whelk.spring.data.logging.writer.ReturnTypeWriter;

public interface Log {

    public interface Trace {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            Log.Args withArgs() default @Log.Args;
            Log.ReturnType withReturnType() default @Log.ReturnType;
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

    }

    public interface Debug {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            Log.Args withArgs() default @Log.Args;
            Log.ReturnType withReturnType() default @Log.ReturnType;
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

    }

    public interface Info {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            Log.Args withArgs() default @Log.Args;
            Log.ReturnType withReturnType() default @Log.ReturnType;
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

    }

    public interface Warn {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            Log.Args withArgs() default @Log.Args;
            Log.ReturnType withReturnType() default @Log.ReturnType;
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

    }

    public interface Error {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            Log.Args withArgs() default @Log.Args;
            Log.ReturnType withReturnType() default @Log.ReturnType;
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

    }

    public interface Fatal {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            Log.Args withArgs() default @Log.Args;
            Log.ReturnType withReturnType() default @Log.ReturnType;
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Before {
        LogLevel withLevel() default LogLevel.DEBUG;
        Log.Args withArgs() default @Log.Args;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface After {
        LogLevel withLevel() default LogLevel.DEBUG;
        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterReturning {
        LogLevel withLevel() default LogLevel.DEBUG;
        Log.ReturnType withReturnType() default @Log.ReturnType;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterThrowing {
        LogLevel withLevel() default LogLevel.ERROR;
        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Around {
        LogLevel withLevel() default LogLevel.DEBUG;
        Log.Args withArgs() default @Log.Args;
        Log.ReturnType withReturnType() default @Log.ReturnType;
        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface Args { 
        boolean enabled() default true;
        Class<? extends ArgWriter> withWriter() default ArgWriter.class;
    }

    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface ReturnType { 
        boolean enabled() default true;
        Class<? extends ReturnTypeWriter> withWriter() default ReturnTypeWriter.class;
    }

    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface ReturnException { 
        boolean withStacktrace () default true;
        boolean withOverride() default true;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Span {
    }

}
