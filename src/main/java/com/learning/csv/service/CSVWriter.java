package com.learning.csv.service;

import com.learning.csv.entity.ConverterEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class CSVWriter implements Writer {

    String path;
    File writtenFile;
    public CSVWriter() {
    }

    public CSVWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(String str) {


            writtenFile = Path.of(path).toFile();

            try (PrintWriter writer = new PrintWriter(writtenFile)) {

                writer.write(str);

            } catch (FileNotFoundException e) {

                System.out.println(e.getMessage());
            }


    }

}
