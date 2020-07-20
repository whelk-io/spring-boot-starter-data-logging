package io.whelk.spring.data.logging.configurer;

import io.whelk.spring.data.logging.writer.ArgWriter;
import io.whelk.spring.data.logging.writer.ReturnTypeWriter;
import lombok.NonNull;

public interface LoggingConfigurer {

    @NonNull
    String beforeMessage();

    @NonNull
    String beforeWithArgsMessage();

    @NonNull
    String afterMessage();

    @NonNull
    String afterReturningMessage();

    @NonNull
    String afterThrowingMessage();

    @NonNull
    ArgWriter argWriter();

    @NonNull
    ReturnTypeWriter returnTypeWriter();

}