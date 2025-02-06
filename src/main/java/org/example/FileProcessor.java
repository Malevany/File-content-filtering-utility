package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public final class FileProcessor {
    public static void processFile(String filePath, DataStorage dataStorage) throws FileSystemException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                dataStorage.add(line);
            }
        } catch (IOException e) {
            throw new FileSystemException("Ошибка при чтении файла: " + e.getMessage());
        }
    }
    public static void saveToNewFile(Trackable data, File file) throws FileSystemException {
        if (!data.getElements().isEmpty()) {
            try {
                Files.write(file.toPath(), data.getElements());
            } catch (IOException e) {
                throw new FileSystemException("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }
    public static void saveToExistingFile(Trackable data, File file) throws FileSystemException {
        if (!data.getElements().isEmpty()) {
            try {
                Files.write(file.toPath(), data.getElements(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new FileSystemException("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }
}
