package io.whelk.spring.data.logging.writer;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

@FieldDefaults
@RequiredArgsConstructor
public class JacksonArgWriter implements ArgWriter {

    @NonNull
    ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public <T> String argToString(T arg) {
        return objectMapper.writeValueAsString(arg);
    }

}