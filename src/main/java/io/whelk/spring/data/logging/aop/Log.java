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

        /**
         * Log trace message before method is invoked
         * 
         * @param withArgs - Log.Args configuration for converting method parameters to
         *                 String
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        /**
         * Log trace message after method is invoked
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Log trace message after method is invoked, including any Object returned
         * 
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        /**
         * Log trace message after method throws uncaught exception
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Wrap method with trace logging before, after, and on uncaught exception.
         * 
         * @param withArgs            - Log.Args configuration for converting method
         *                            parameters to String
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
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

        /**
         * Log debug message before method is invoked
         * 
         * @param withArgs - Log.Args configuration for converting method parameters to
         *                 String
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        /**
         * Log debug message after method is invoked
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Log debug message after method is invoked, including any Object returned
         * 
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        /**
         * Log debug message after method throws uncaught exception
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Wrap method with debug logging before, after, and on uncaught exception.
         * 
         * @param withArgs            - Log.Args configuration for converting method
         *                            parameters to String
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
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

        /**
         * Log info message before method is invoked
         * 
         * @param withArgs - Log.Args configuration for converting method parameters to
         *                 String
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        /**
         * Log info message after method is invoked
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Log info message after method is invoked, including any Object returned
         * 
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        /**
         * Log info message after method throws uncaught exception
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Wrap method with info logging before, after, and on uncaught exception.
         * 
         * @param withArgs            - Log.Args configuration for converting method
         *                            parameters to String
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
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

        /**
         * Log warn message before method is invoked
         * 
         * @param withArgs - Log.Args configuration for converting method parameters to
         *                 String
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        /**
         * Log warn message after method is invoked
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Log warn message after method is invoked, including any Object returned
         * 
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        /**
         * Log warn message after method throws uncaught exception
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Wrap method with warn logging before, after, and on uncaught exception.
         * 
         * @param withArgs            - Log.Args configuration for converting method
         *                            parameters to String
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
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

        /**
         * Log error message before method is invoked
         * 
         * @param withArgs - Log.Args configuration for converting method parameters to
         *                 String
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        /**
         * Log error message after method is invoked
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Log error message after method is invoked, including any Object returned
         * 
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        /**
         * Log error message after method throws uncaught exception
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Wrap method with error logging before, after, and on uncaught exception.
         * 
         * @param withArgs            - Log.Args configuration for converting method
         *                            parameters to String
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
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

        /**
         * Log fatal message before method is invoked
         * 
         * @param withArgs - Log.Args configuration for converting method parameters to
         *                 String
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            Log.Args withArgs() default @Log.Args;
        }

        /**
         * Log fatal message after method is invoked
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Log fatal message after method is invoked, including any Object returned
         * 
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
            Log.ReturnType withReturnType() default @Log.ReturnType;
        }

        /**
         * Log fatal message after method throws uncaught exception
         * 
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {
            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

        /**
         * Wrap method with fatal logging before, after, and on uncaught exception.
         * 
         * @param withArgs            - Log.Args configuration for converting method
         *                            parameters to String
         * @param withReturnType      - Log.ReturnType configuration for converting
         *                            value returned from method to String
         * @param withReturnException - Log.ReturnException configuration for logging
         *                            uncaught exceptions from method
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            Log.Args withArgs() default @Log.Args;

            Log.ReturnType withReturnType() default @Log.ReturnType;

            Log.ReturnException withReturnException() default @Log.ReturnException;
        }

    }

    /**
     * Log message before method is invoked
     * 
     * @param withLevel - Log.Level to write log message, default Log.Level.Debug
     * @param withArgs  - Log.Args configuration for converting method parameters to
     *                  String
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Before {
        Log.Level withLevel() default Log.Level.Debug;

        Log.Args withArgs() default @Log.Args;
    }

    /**
     * Log message after method is invoked
     * 
     * @param withLevel           - Log.Level to write log message, default
     *                            Log.Level.Debug
     * @param withReturnException - Log.ReturnException configuration for logging
     *                            uncaught exceptions from method
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface After {
        Log.Level withLevel() default Log.Level.Debug;

        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    /**
     * Log message after method is invoked, including any Object returned
     * 
     * @param withLevel           - Log.Level to write log message
     * @param withReturnType      - Log.ReturnType configuration for converting
     *                            value returned from method to String
     * @param withReturnException - Log.ReturnException configuration for logging
     *                            uncaught exceptions from method
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterReturning {
        Log.Level withLevel() default Log.Level.Debug;

        Log.ReturnType withReturnType() default @Log.ReturnType;

        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    /**
     * Log message after method throws uncaught exception
     * 
     * @param withLevel           - Log.Level to write log message
     * @param withReturnException - Log.ReturnException configuration for logging
     *                            uncaught exceptions from method
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterThrowing {
        Log.Level withLevel() default Log.Level.Error;

        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    /**
     * Wrap method with logging before, after, and on uncaught exception.
     * 
     * @param withLevel           - Log.Level to write log message
     * @param withArgs            - Log.Args configuration for converting method
     *                            parameters to String
     * @param withReturnType      - Log.ReturnType configuration for converting
     *                            value returned from method to String
     * @param withReturnException - Log.ReturnException configuration for logging
     *                            uncaught exceptions from method
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Around {
        Log.Level withLevel() default Log.Level.Debug;

        Log.Args withArgs() default @Log.Args;

        Log.ReturnType withReturnType() default @Log.ReturnType;

        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    /**
     * Configuration for writing parameters on annotated method to logs
     * 
     * @param enabled    - default true
     * @param withWriter - override global settings with custom writer for
     *                   converting method parameters to String
     */
    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface Args {
        boolean enabled() default true;

        Class<? extends ArgWriter> withWriter() default ArgWriter.class;
    }

    /**
     * Configuration for writing any value returned by annotated method
     * 
     * @param enabled    - default true
     * @param withWriter - override global settings with custom writer for
     *                   converting value returned from method to String
     */
    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface ReturnType {
        boolean enabled() default true;

        Class<? extends ReturnTypeWriter> withWriter() default ReturnTypeWriter.class;
    }

    /**
     * Configuration for method logging when exception is thrown
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
