package io.whelk.spring.data.logging.auto;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.whelk.spring.data.logging.configurer.LoggingConfigurer;
import io.whelk.spring.data.logging.configurer.SimpleLoggingConfigurer;
import io.whelk.spring.data.logging.writer.ArgWriter;
import io.whelk.spring.data.logging.writer.FullArgWriter;
import io.whelk.spring.data.logging.writer.FullReturnTypeWriter;
import io.whelk.spring.data.logging.writer.JacksonArgWriter;
import io.whelk.spring.data.logging.writer.JacksonReturnTypeWriter;
import io.whelk.spring.data.logging.writer.ReturnTypeWriter;
import io.whelk.spring.data.logging.writer.SimpleArgWriter;
import io.whelk.spring.data.logging.writer.SimpleReturnTypeWriter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@ComponentScan("io.whelk.spring.data.logging")
public class LoggingAutoConfiguration {

    @Bean("loggingObjectMapper")
    @Primary
    @ConditionalOnMissingBean(value = ObjectMapper.class, name = "loggingObjectMapper")
    public ObjectMapper loggingObjectMapper() { 
        return new ObjectMapper();
    }

    @Bean
    @ConditionalOnMissingBean(LoggingConfigurer.class)
    public LoggingConfigurer loggingConfigurer(ArgWriter argWriter, ReturnTypeWriter returnTypeWriter) {
        return new SimpleLoggingConfigurer(argWriter, returnTypeWriter);
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(ArgWriter.class)
    public ArgWriter argWriter() {
        return simpleArgWriter();
    }

    @Bean
    public SimpleArgWriter simpleArgWriter() { 
        return new SimpleArgWriter();
    }

    @Bean
    public FullArgWriter fullArgWriter() { 
        return new FullArgWriter();
    }

    @Bean
    @ConditionalOnBean(value = ObjectMapper.class, name = "loggingObjectMapper")
    public JacksonArgWriter JacksonArgWriter(ObjectMapper loggingObjectMapper) { 
        return new JacksonArgWriter(loggingObjectMapper);
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(ReturnTypeWriter.class)
    public ReturnTypeWriter returnTypeWriter() { 
        return simpleReturnTypeWriter();
    }

    @Bean
    public SimpleReturnTypeWriter simpleReturnTypeWriter() { 
        return new SimpleReturnTypeWriter();
    }

    @Bean
    public FullReturnTypeWriter fullReturnTypeWriter() { 
        return new FullReturnTypeWriter();
    }

    @Bean
    @ConditionalOnBean(value = ObjectMapper.class, name = "loggingObjectMapper")
    public JacksonReturnTypeWriter jacksonReturnTypeWriter(ObjectMapper objectMapper) { 
        return new JacksonReturnTypeWriter(objectMapper);
    }

}