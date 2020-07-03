package io.whelk.spring.data.logging.sleuth;

import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(brave.Tracer.class)
public class TracerConfiguration {

    @Bean
    public TracerAspect tracerAspect(Optional<brave.Tracer> tracer) {
        return new TracerAspect(tracer);
    }

}