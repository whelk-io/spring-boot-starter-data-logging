package io.whelk.spring.data.logging.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.boot.logging.LogLevel;

public interface Log {

    public interface Trace { 

        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
        }

    }

    public interface Debug { 

        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
        }

    }

    public interface Info { 

        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
        }

    }

    public interface Warn { 

        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
        }

    }

    public interface Error { 

        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
        }

    }

    public interface Fatal { 

        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Before {
            boolean withArgs() default true;
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface After {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface AfterReturning {
        }
    
        @Target(METHOD)
        @Retention(RUNTIME)
        public @interface Around {
            boolean withArgs() default true;
            boolean withReturnType() default true;
        }

    }

    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Before {
        boolean withArgs() default true;
        LogLevel withLevel() default LogLevel.DEBUG;
    }

    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface After {
        LogLevel withLevel() default LogLevel.DEBUG;
    }

    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface AfterReturning {
        LogLevel withLevel() default LogLevel.DEBUG;
    }

    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Around {
        boolean withArgs() default true;
        boolean withReturnType() default true;
        LogLevel withLevel() default LogLevel.DEBUG;
    }

    @Target(METHOD)
    @Retention(RUNTIME)
    public @interface Span { }

}
