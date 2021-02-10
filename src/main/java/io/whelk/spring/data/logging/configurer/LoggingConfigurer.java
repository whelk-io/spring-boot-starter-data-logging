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

/**
 * @author Zack Teater
 * @since 0.1.0
 */
public interface LoggingConfigurer {

    /**
     * @return message format for generating log message before method executes
     *         regardless of method parameters
     */
    @NonNull
    String beforeMessage();

    /**
     * @return message format for generating log message before method executes with
     *         method parameters
     */
    @NonNull
    String beforeWithArgsMessage();

    /**
     * @return message format for generating log message after method executes
     *         regardless of return type
     */
    @NonNull
    String afterMessage();

    /**
     * @return message format for generating log message after method executes and
     *         returns a value
     */
    @NonNull
    String afterReturningMessage();

    /**
     * @return message format for generating log message after method throws an
     *         exception
     */
    @NonNull
    String afterThrowingMessage();

    /**
     * @return {@link ArgWriter} for formatting method input parameters on log
     */
    @NonNull
    ArgWriter argWriter();

    /**
     * @return {@link ReturnTypeWriter} for formatting method return type on log
     */
    @NonNull
    ReturnTypeWriter returnTypeWriter();

}