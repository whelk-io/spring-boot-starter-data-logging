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

import javax.annotation.PostConstruct;

import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
@Configuration
@RequiredArgsConstructor
public class LogLevelConfiguration {

    private final LoggingSystem loggingSystem;

    /**
     * Initialize default log levels for Spring-Data packages
     */
    @PostConstruct
    public void setup() {
        setLogLevel("org.springframework.data.repository.CrudRepository", LogLevel.DEBUG);
        setLogLevel("org.springframework.data.jpa.repository.JpaRepository", LogLevel.DEBUG);
        setLogLevel("org.springframework.data.repository.PagingAndSortingRepository", LogLevel.DEBUG);
        setLogLevel("org.springframework.data.repository.query.QueryByExampleExecutor", LogLevel.DEBUG);
    }

    private void setLogLevel(String loggerName, LogLevel level) {
        var loggerConfiguration = loggingSystem.getLoggerConfiguration(loggerName);
        if (loggerConfiguration == null || loggerConfiguration.getConfiguredLevel() == null) {
            loggingSystem.setLogLevel(loggerName, level);
        }
    }

}