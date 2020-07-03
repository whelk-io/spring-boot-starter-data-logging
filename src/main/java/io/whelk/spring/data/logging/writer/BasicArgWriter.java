package io.whelk.spring.data.logging.writer;

public class BasicArgWriter implements ArgWriter {

    @Override
    public <T> String argToString(T arg) {
        return arg != null ? arg.toString() : "null";
    }

}