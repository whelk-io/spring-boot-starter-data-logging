package io.whelk.spring.data.logging.configurer;

import io.whelk.spring.data.logging.writer.ArgWriter;
import lombok.NonNull;

public interface LoggingConfigurer {

    @NonNull
    String beforeMethodMessage();

    @NonNull
    String beforeMethodWithArgsMessage();

    @NonNull
    String afterMethodMessage();

    @NonNull
    String afterMethodWithReturnType();

    @NonNull
    ArgWriter argWriter();

}