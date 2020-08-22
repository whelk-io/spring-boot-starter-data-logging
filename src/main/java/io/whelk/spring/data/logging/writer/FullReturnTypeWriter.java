package io.whelk.spring.data.logging.writer;

import java.util.Objects;
import java.util.Optional;

public class FullReturnTypeWriter implements ReturnTypeWriter {

    @Override
    public <T> String toString(T t) {

        if (Optional.class.isInstance(t)) {
            var opt = Optional.class.cast(t);
            var val = opt.isPresent() ? opt.get() : null;
            return Objects.toString(val);
        }
        
        return Objects.toString(t);
        
    }

}