package io.whelk.spring.data.logging.writer;

import java.util.Optional;

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
    public <T> String argToString(T t) {

        if (Optional.class.isInstance(t)) {
            var opt = Optional.class.cast(t);
            var val = opt.isPresent() ? opt.get() : null;
            return objectMapper.writeValueAsString(val);
        }

        return objectMapper.writeValueAsString(t);
        
    }

}