package com.task.input.impl;

import com.task.adapter.impl.InputDataAdapter;
import com.task.input.Reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileInputManager {
    private InputDataAdapter adapter = new InputDataAdapter();

    private final String INPUT_FILES_DIRECTORY = "";

    public void readData(){
        try{
            getPaths().forEach(p->{
                adapter.adapt(new FileReader(p).getData());
            });
            adapter.validEmployees();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private List<String> getPaths() throws IOException{
        try (Stream<Path> stream = Files.list(Paths.get(INPUT_FILES_DIRECTORY))) {
            return stream.filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(p->p.endsWith(".sb"))
                    .toList();
        }
    }
}
