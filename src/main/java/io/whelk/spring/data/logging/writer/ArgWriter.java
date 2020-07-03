package io.whelk.spring.data.logging.writer;

public interface ArgWriter {

    <T> String argToString(T arg);

}