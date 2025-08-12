package com.task.input.impl;

import com.task.adapter.impl.InputDataAdapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileInputManager {
    private final InputDataAdapter adapter = new InputDataAdapter();

    private final String INPUT_FILES_DIRECTORY = "";

    public void readData() throws IOException {
        getPaths().forEach(p -> {
            adapter.adapt(new FileReader(p).getData());
        });
        adapter.validEmployees();
    }

    private List<String> getPaths() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(INPUT_FILES_DIRECTORY))) {
            List<String> paths = stream.filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(p -> p.endsWith(".sb"))
                    .toList();
            if (paths.isEmpty()) {
                throw new IOException("Files *.sb doesn't exist");
            }
            return paths;
        }
    }
}
