package io.whelk.spring.data.logging.writer;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class JacksonArgWriter implements ArgWriter {

    @NonNull
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public <T> String argToString(T arg) {
        return objectMapper.writeValueAsString(arg);
    }

}