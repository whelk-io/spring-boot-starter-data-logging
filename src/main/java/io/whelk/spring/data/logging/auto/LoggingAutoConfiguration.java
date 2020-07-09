package io.whelk.spring.data.logging.auto;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.whelk.spring.data.logging.configurer.BasicLoggingConfigurer;
import io.whelk.spring.data.logging.configurer.LoggingConfigurer;
import io.whelk.spring.data.logging.writer.ArgWriter;
import io.whelk.spring.data.logging.writer.BasicArgWriter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@ComponentScan("io.whelk.spring.data.logging")
public class LoggingAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ArgWriter.class)
    public ArgWriter argWriter() {
        return new BasicArgWriter();
    }

    @Bean
    @ConditionalOnMissingBean(LoggingConfigurer.class)
    public LoggingConfigurer loggingConfigurer(ArgWriter argWriter) {
        return new BasicLoggingConfigurer(argWriter);
    }

}