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

/**
 * @author Zack Teater
 * @since 0.1.0
 */
@RequiredArgsConstructor
@Configuration
@ComponentScan("io.whelk.spring.data.logging")
public class LoggingAutoConfiguration {

    /**
     * @return default {@link ObjectMapper} when none defined
     */
    @Bean("loggingObjectMapper")
    @Primary
    @ConditionalOnMissingBean(value = ObjectMapper.class, name = "loggingObjectMapper")
    public ObjectMapper loggingObjectMapper() {
        return new ObjectMapper();
    }

    /**
     * 
     * @param argWriter        - {@link ArgWriter} for configuring arguments in log
     *                         messages
     * @param returnTypeWriter - {@link ReturnTypeWriter} for configuring return
     *                         type in log messages
     * @return {@link LoggingConfigurer} with both writers
     */
    @Bean
    @ConditionalOnMissingBean(LoggingConfigurer.class)
    public LoggingConfigurer loggingConfigurer(ArgWriter argWriter, ReturnTypeWriter returnTypeWriter) {
        return new SimpleLoggingConfigurer(argWriter, returnTypeWriter);
    }

    /**
     * @return default {@link ArgWriter} when no other writer is wired
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean(ArgWriter.class)
    public ArgWriter argWriter() {
        return simpleArgWriter();
    }

    /**
     * @return default {@link SimpleArgWriter} when no other writer is wired
     */
    @Bean
    public SimpleArgWriter simpleArgWriter() {
        return new SimpleArgWriter();
    }

    /**
     * @return default {@link FullArgWriter} when no other writer is wired
     */
    @Bean
    public FullArgWriter fullArgWriter() {
        return new FullArgWriter();
    }

    /**
     * @param loggingObjectMapper - default {@link ObjectMapper}
     * @return default {@link JacksonArgWriter} when no other writer is wired
     */
    @Bean
    @ConditionalOnBean(value = ObjectMapper.class, name = "loggingObjectMapper")
    public JacksonArgWriter JacksonArgWriter(ObjectMapper loggingObjectMapper) {
        return new JacksonArgWriter(loggingObjectMapper);
    }

    /**
     * @return default {@link ReturnTypeWriter} when no other writer is wired
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean(ReturnTypeWriter.class)
    public ReturnTypeWriter returnTypeWriter() {
        return simpleReturnTypeWriter();
    }

    /**
     * @return default {@link SimpleReturnTypeWriter} when no other writer is wired
     */
    @Bean
    public SimpleReturnTypeWriter simpleReturnTypeWriter() {
        return new SimpleReturnTypeWriter();
    }

    /**
     * @return default {@link FullReturnTypeWriter} when no other writer is wired
     */
    @Bean
    public FullReturnTypeWriter fullReturnTypeWriter() {
        return new FullReturnTypeWriter();
    }

    /**
     * @param objectMapper - default {@link ObjectMapper}
     * @return default {@link JacksonReturnTypeWriter} when no other writer is wired
     */
    @Bean
    @ConditionalOnBean(value = ObjectMapper.class, name = "loggingObjectMapper")
    public JacksonReturnTypeWriter jacksonReturnTypeWriter(ObjectMapper objectMapper) {
        return new JacksonReturnTypeWriter(objectMapper);
    }

}