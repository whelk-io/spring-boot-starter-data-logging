package io.whelk.spring.data.logging.auto;

import javax.annotation.PostConstruct;

import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class LogLevelConfiguration {

    private final LoggingSystem loggingSystem;

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