package io.whelk.spring.data.logging.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

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
            boolean withArgs() default true;
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
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
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
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
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
            boolean withReturnType() default true;
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
            boolean withStacktrace() default true;
        }

    }

    public interface Debug {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
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
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
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
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
            boolean withReturnType() default true;
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
            boolean withStacktrace() default true;
        }

    }

    public interface Info {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
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
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
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
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
            boolean withReturnType() default true;
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
            boolean withStacktrace() default true;
        }

    }

    public interface Warn {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
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
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
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
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
            boolean withReturnType() default true;
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
            boolean withStacktrace() default true;
        }

    }

    public interface Error {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
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
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
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
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
            boolean withReturnType() default true;
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
            boolean withStacktrace() default true;
        }

    }

    public interface Fatal {

        @Inherited
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
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
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
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
            Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
            boolean withReturnType() default true;
            Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
            boolean withStacktrace() default true;
        }

    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Before {
        boolean withArgs() default true;
        Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
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
        Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
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
        Class<? extends ArgWriter> withArgWriter() default ArgWriter.class;
        boolean withReturnType() default true;
        LogLevel withLevel() default LogLevel.DEBUG;
        Class<? extends ReturnTypeWriter> withReturnTypeWriter() default ReturnTypeWriter.class;
        boolean withStacktrace() default true;
    }

    @Inherited
    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Span {
    }

}
