package io.whelk.spring.data.logging.writer;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class SimpleArgWriter implements ArgWriter {

    @Override
    public <T> String argToString(T t) {

        if (Optional.class.isInstance(t)) {
            var opt = Optional.class.cast(t);
            var val = opt.isPresent() ? opt.get() : null;
            return Objects.toString(val);
        }

        if (Collection.class.isInstance(t)) {
            var c = Collection.class.cast(t);
            return String.format("%s[size=%d]", t.getClass().getSimpleName(), c.size());
        }
        
        return Objects.toString(t);
    }

}