package io.whelk.spring.data.logging.configurer;

import io.whelk.spring.data.logging.writer.ArgWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BasicLoggingConfigurer implements LoggingConfigurer {

    public static final String BEFORE = "before [method=%s]";
    public static final String BEFORE_WITH_ARGS = "before [method=%s, args=(%s)]";
    public static final String AFTER = "after [method=%s]";
    public static final String AFTER_RETURNING = "after [method=%s, return=%s]";
    public static final String AFTER_THROWING = "thrown [method=%s, exception=%s, message=%s]";

    private final ArgWriter argWriter;

    @Override
    public @NonNull String beforeMessage() {
        return BEFORE;
    }

    @Override
    public @NonNull String beforeWithArgsMessage() {
        return BEFORE_WITH_ARGS;
    }

    @Override
    public @NonNull String afterMessage() {
        return AFTER;
    }

    @Override
    public @NonNull String afterReturningMessage() {
        return AFTER_RETURNING;
    }

    @Override
    public @NonNull String afterThrowingMessage() {
        return AFTER_THROWING;
    }

    @Override
    public @NonNull ArgWriter argWriter() {
        return argWriter;
    }

}