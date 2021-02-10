/*
 * Copyright 2021 Whelk Contributors (http://whelk.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.whelk.spring.data.logging.writer;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
public class SimpleArgWriter implements ArgWriter {

    /**
     * {inheritDoc}
     */
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