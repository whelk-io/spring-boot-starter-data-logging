package io.whelk.spring.data.logging.writer;

public interface ReturnTypeWriter {

    <T> String toString(T t);

}