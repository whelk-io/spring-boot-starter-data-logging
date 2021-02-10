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
package io.whelk.spring.data.logging.sleuth;

import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
@Configuration
@ConditionalOnClass(brave.Tracer.class)
public class TracerConfiguration {

    /**
     * 
     * @param tracer - for handling pointcuts related to Tracing
     * @return {@link TracerAdvice} when Sleuth is on the classpath
     */
    @Bean
    public TracerAdvice tracerAspect(Optional<brave.Tracer> tracer) {
        return new TracerAdvice(tracer);
    }

}