package io.whelk.spring.data.logging.rest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
@ConditionalOnClass(HandlerInterceptor.class)
public class RestConfiguration {

    @Bean
    public MappedInterceptor traceIdInterceptor() {
        return new MappedInterceptor(new String[] { "/**" }, new TraceIdInterceptor());
    }

}