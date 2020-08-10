package io.whelk.spring.data.logging.writer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class SimpleArgWriter implements ArgWriter {

    @Override
    public <T> String argToString(T arg) {

        if (arg == null) {
            return Objects.toString(arg);
        }

        if (Optional.class.isInstance(arg)) {
            var opt = Optional.class.cast(arg);
            var val = opt.isPresent() ? opt.get() : null;
            return Objects.toString(val);
        }

        if (arg.getClass().isArray()) {
            Object[] arr = (Object[]) arg;
            return String.format("%s[size=%d]", arg.getClass().getSimpleName(), arr.length);
        }

        if (Collection.class.isInstance(arg)) {
            var c = Collection.class.cast(arg);
            return String.format("%s[size=%d]", arg.getClass().getSimpleName(), c.size());
        }
        
        return Objects.toString(arg);
    }

}