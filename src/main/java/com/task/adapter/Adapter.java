package com.task.adapter;

import java.util.stream.Stream;

public interface Adapter<R,T> {
    R adapt(Stream<T> inputValue);
}
