package io.whelk.spring.data.logging.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

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
        Log.Level withLevel() default Log.Level.Debug;

        Log.Args withArgs() default @Log.Args;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface After {
        Log.Level withLevel() default Log.Level.Debug;

        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterReturning {
        Log.Level withLevel() default Log.Level.Debug;

        Log.ReturnType withReturnType() default @Log.ReturnType;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterThrowing {
        Log.Level withLevel() default Log.Level.Error;

        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Around {
        Log.Level withLevel() default Log.Level.Debug;

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

    /**
     * Configuration for method logging when exception is thrown.
     * 
     * @param withStackTrace - log stacktrace with exception is thrown, default true
     * @param withOverride   - override withLevel on logging annotations with
     *                       <code>Log.Level.Error</code> when exception is thrown,
     *                       default is true
     */
    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface ReturnException {
        boolean withStackTrace() default true;

        Log.Level withLogLevel() default Log.Level.Error;
    }

    enum Level {
        Trace, Debug, Info, Warn, Error, Fatal, Off
    }

}
