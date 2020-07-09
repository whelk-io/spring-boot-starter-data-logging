package io.whelk.spring.data.logging.configurer;

import io.whelk.spring.data.logging.writer.ArgWriter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BasicLoggingConfigurer implements LoggingConfigurer {

    public static final String AFTER_METHOD = "after [method=%s]";
    public static final String AFTER_METHOD_WITH_RETURN_TYPE = "after [method=%s, return=%s]";
    public static final String BEFORE_METHOD = "before [method=%s]";
    public static final String BEFORE_METHOD_WITH_ARGS = "before [method=%s, args=(%s)]";

    private final ArgWriter argWriter;

    @Override
    public String beforeMethodMessage() {
        return BEFORE_METHOD;
    }

    @Override
    public String beforeMethodWithArgsMessage() {
        return BEFORE_METHOD_WITH_ARGS;
    }

    @Override
    public String afterMethodMessage() {
        return AFTER_METHOD;
    }

    @Override
    public String afterMethodWithReturnType() {
        return AFTER_METHOD_WITH_RETURN_TYPE;
    }

    @Override
    public ArgWriter argWriter() {
        return argWriter;
    }

}