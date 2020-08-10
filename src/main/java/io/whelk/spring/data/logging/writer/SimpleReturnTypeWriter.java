package io.whelk.spring.data.logging.writer;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class SimpleReturnTypeWriter implements ReturnTypeWriter {

    @Override
    public <T> String toString(T t) {

        if (t == null) {
            return Objects.toString(t);
        }
        
        if (Optional.class.isInstance(t)) {
            var opt = Optional.class.cast(t);
            var val = opt.isPresent() ? opt.get() : null;
            return Objects.toString(val);
        } 

        if (t.getClass().isArray()) {
            Object[] arr = (Object[]) t;
            return String.format("%s[size=%d]", t.getClass().getSimpleName(), arr.length);
        }
        
        if (Collection.class.isInstance(t)) {
            var c = Collection.class.cast(t);
            return String.format("%s[size=%d]", t.getClass().getSimpleName(), c.size());
        }

        return Objects.toString(t);

    }

}