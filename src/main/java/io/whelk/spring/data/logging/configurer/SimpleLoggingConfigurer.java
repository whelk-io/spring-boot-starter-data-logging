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
package io.whelk.spring.data.logging.configurer;

import io.whelk.spring.data.logging.writer.ArgWriter;
import io.whelk.spring.data.logging.writer.ReturnTypeWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
@RequiredArgsConstructor
public class SimpleLoggingConfigurer implements LoggingConfigurer {

    private static final String BEFORE = "before [method=%s]";
    private static final String BEFORE_WITH_ARGS = "before [method=%s, args=(%s)]";
    private static final String AFTER = "after [method=%s]";
    private static final String AFTER_RETURNING = "after [method=%s, return=%s]";
    private static final String AFTER_THROWING = "thrown [method=%s, exception=%s, message=%s]";

    private final ArgWriter argWriter;
    private final ReturnTypeWriter returnTypeWriter;

    /**
     * {@inheritDoc}
     */
    @Override
    public @NonNull String beforeMessage() {
        return BEFORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NonNull String beforeWithArgsMessage() {
        return BEFORE_WITH_ARGS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NonNull String afterMessage() {
        return AFTER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NonNull String afterReturningMessage() {
        return AFTER_RETURNING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NonNull String afterThrowingMessage() {
        return AFTER_THROWING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NonNull ArgWriter argWriter() {
        return argWriter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NonNull ReturnTypeWriter returnTypeWriter() {
        return returnTypeWriter;
    }

}