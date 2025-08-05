package com.task.parser;

public interface Parser<T> {
    T parse(String line);
}
