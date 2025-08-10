package com.task.parser;

public interface Parser<T,F> {
    T parse(F f);
}
