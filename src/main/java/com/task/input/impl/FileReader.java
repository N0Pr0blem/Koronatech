package com.task.input.impl;

import com.task.input.Reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader implements Reader {
    private final Path path;

    public FileReader(String path) {
        this.path = Path.of(path);
    }

    @Override
    public Stream<String> getData() {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            System.out.println("Wrong input file path");
            return Stream.empty();
        }
    }
}
