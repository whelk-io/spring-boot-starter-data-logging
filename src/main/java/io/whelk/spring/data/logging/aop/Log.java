/*
 * Copyright 2021 Whelk Contributors (http://whelk.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.whelk.spring.data.logging.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.whelk.spring.data.logging.writer.ArgWriter;
import io.whelk.spring.data.logging.writer.ReturnTypeWriter;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
public interface Log {

    /**
     * Log annotated methods at Trace level
     */
    public interface Trace {

        /**
         * Log trace message before method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

        }

        /**
         * Log trace message after method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Log trace message after method is invoked, including any Object returned
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

        }

        /**
         * Log trace message after method throws uncaught exception
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Wrap method with trace logging before, after, and on uncaught exception.
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

    }

    /**
     * Log annotated methods at Debug level
     */
    public interface Debug {

        /**
         * Log Debug message before method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;
        }

        /**
         * Log Debug message after method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Log Debug message after method is invoked, including any Object returned
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

        }

        /**
         * Log Debug message after method throws uncaught exception
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Wrap method with Debug logging before, after, and on uncaught exception.
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

    }

    /**
     * Log annotated methods at Info level
     */
    public interface Info {

        /**
         * Log info message before method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;
        }

        /**
         * Log info message after method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Log info message after method is invoked, including any Object returned
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

        }

        /**
         * Log info message after method throws uncaught exception
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Wrap method with info logging before, after, and on uncaught exception.
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

    }

    /**
     * Log annotated methods at Warn level
     */
    public interface Warn {

        /**
         * Log warn message before method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

        }

        /**
         * Log warn message after method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Log warn message after method is invoked, including any Object returned
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

        }

        /**
         * Log warn message after method throws uncaught exception
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Wrap method with warn logging before, after, and on uncaught exception.
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

    }

    /**
     * Log annotated methods at Error level
     */
    public interface Error {

        /**
         * Log Error message before method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

        }

        /**
         * Log Error message after method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Log Error message after method is invoked, including any Object returned
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

        }

        /**
         * Log Error message after method throws uncaught exception
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Wrap method with error logging before, after, and on uncaught exception.
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

    }

    /**
     * Log annotated methods at Fatal level
     */
    public interface Fatal {

        /**
         * Log fatal message before method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

        }

        /**
         * Log fatal message after method is invoked
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Log fatal message after method is invoked, including any Object returned
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

        }

        /**
         * Log fatal message after method throws uncaught exception
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterThrowing {

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

        /**
         * Wrap method with fatal logging before, after, and on uncaught exception.
         */
        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {

            /**
             * @return configuration for converting method parameters to String
             */
            Log.Args withArgs() default @Log.Args;

            /**
             * @return configuration for converting value returned from method to String
             */
            Log.ReturnType withReturnType() default @Log.ReturnType;

            /**
             * @return configuration for logging uncaught exceptions from method
             */
            Log.ReturnException withReturnException() default @Log.ReturnException;

        }

    }

    /**
     * Log message before method is invoked
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Before {

        /**
         * @return Level to write log message, default Log.Level.Debug
         */
        Log.Level withLevel() default Log.Level.Debug;

        /**
         * @return configuration for converting method parameters to String
         */
        Log.Args withArgs() default @Log.Args;

    }

    /**
     * Log message after method is invoked
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface After {

        /**
         * @return Level to write log message, default Log.Level.Debug
         */
        Log.Level withLevel() default Log.Level.Debug;

        /**
         * @return configuration for logging uncaught exceptions from method
         */
        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    /**
     * Log message after method is invoked, including any Object returned
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterReturning {

        /**
         * @return Level to write log message, default Log.Level.Debug
         */
        Log.Level withLevel() default Log.Level.Debug;

        /**
         * @return configuration for converting value returned from method to String
         */
        Log.ReturnType withReturnType() default @Log.ReturnType;

        /**
         * @return configuration for logging uncaught exceptions from method
         */
        Log.ReturnException withReturnException() default @Log.ReturnException;
    }

    /**
     * Log message after method throws uncaught exception
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterThrowing {

        /**
         * @return Level to write log message, default Log.Level.Debug
         */
        Log.Level withLevel() default Log.Level.Error;

        /**
         * @return configuration for logging uncaught exceptions from method
         */
        Log.ReturnException withReturnException() default @Log.ReturnException;

    }

    /**
     * Wrap method with logging before, after, and on uncaught exception.
     */
    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Around {

        /**
         * @return Level to write log message, default Log.Level.Debug
         */
        Log.Level withLevel() default Log.Level.Debug;

        /**
         * @return configuration for converting method parameters to String
         */
        Log.Args withArgs() default @Log.Args;

        /**
         * @return configuration for converting value returned from method to String
         */
        Log.ReturnType withReturnType() default @Log.ReturnType;

        /**
         * @return configuration for logging uncaught exceptions from method
         */
        Log.ReturnException withReturnException() default @Log.ReturnException;

    }

    /**
     * Configuration for writing parameters on annotated method to logs
     */
    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface Args {

        /**
         * @return true by default
         */
        boolean enabled() default true;

        /**
         * @return override global settings with custom writer for converting method
         *         parameters to String
         */
        Class<? extends ArgWriter> withWriter() default ArgWriter.class;

    }

    /**
     * Configuration for writing any value returned by annotated method
     */
    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface ReturnType {

        /**
         * @return true by default
         */
        boolean enabled() default true;

        /**
         * @return override global settings with custom writer for converting value
         *         returned from method to String
         */
        Class<? extends ReturnTypeWriter> withWriter() default ReturnTypeWriter.class;

    }

    /**
     * Configuration for method logging when exception is thrown
     */
    @Inherited
    @Target(ElementType.PARAMETER)
    @Retention(RUNTIME)
    public @interface ReturnException {

        /**
         * @return log stacktrace on exception, by default true
         */
        boolean withStackTrace() default true;

        /**
         * @return override withLevel on logging annotations with
         *         {@code Log.Level.Error} when exception is thrown, default is true
         */
        Log.Level withLogLevel() default Log.Level.Error;

    }

    /**
     * Equivalent to org.springframework.boot.logging.LogLevel
     */
    enum Level {

        /**
         * Equivalent to org.springframework.boot.logging.LogLevel.TRACE
         */
        Trace,

        /**
         * Equivalent to org.springframework.boot.logging.LogLevel.DEBUG
         */
        Debug,

        /**
         * Equivalent to org.springframework.boot.logging.LogLevel.INFO
         */
        Info,

        /**
         * Equivalent to org.springframework.boot.logging.LogLevel.WARN
         */
        Warn,

        /**
         * Equivalent to org.springframework.boot.logging.LogLevel.ERROR
         */
        Error,

        /**
         * Equivalent to org.springframework.boot.logging.LogLevel.FATAL
         */
        Fatal,

        /**
         * Equivalent to org.springframework.boot.logging.LogLevel.OFF
         */
        Off;
    }

}
