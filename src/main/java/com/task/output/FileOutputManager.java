package com.task.output;

import com.task.config.MainData;

import java.io.File;
import java.io.IOException;

public class FileOutputManager {
    private final String OUTPUT_DIRECTORY = "/output/";

    public void print() {

    }

    private void createFiles() {
        try {
            File errorFile = new File(OUTPUT_DIRECTORY + "error.log");
            errorFile.createNewFile();
            MainData.getInstance().getManagers()
                    .findAll()
                    .forEach(m -> {
                        File newFile = new File(OUTPUT_DIRECTORY + m.getDepartmentName() + ".sb");
                        try {
                            newFile.createNewFile();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
