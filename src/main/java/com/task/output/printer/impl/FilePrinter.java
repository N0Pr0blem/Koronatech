package com.task.output.printer.impl;

import com.task.output.printer.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilePrinter implements Printer {

    private final Path path;

    public FilePrinter(String path) {
        this.path = Path.of(path);
    }

    @Override
    public void print(String content) {
        try {
            Files.writeString(path, content + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Wrong file path: " + path);
        }
    }
}
