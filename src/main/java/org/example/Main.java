package org.example;

import java.nio.file.FileSystemException;

public class Main {
    public static void main(String[] args) {
        DataStorage dataStorage = new DataStorage(new StringTracker(), new IntegerTracker(), new FloatTracker());
        CommandArgsProcessor argsProcessor = new CommandArgsProcessor();

        try {
            argsProcessor.processArgs(args);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

        if (argsProcessor.isTxtFilesExists()) {
            try {
                for (int i = 0; i < argsProcessor.getTxtFiles().size(); i++) {
                    FileProcessor.processFile(argsProcessor.getTxtFiles().get(i), dataStorage);
                }
            }
            catch (FileSystemException fileSystemException){
                System.out.println(fileSystemException.getMessage());
                System.exit(0);
            }
        } else {
            System.out.println("Файлы .txt не указаны!");
            System.exit(0);
        }

        try {
            if (argsProcessor.isUseExistFile()) {
                FileProcessor.saveToExistingFile(dataStorage.getStringTracker(), argsProcessor.getStringFile());
                FileProcessor.saveToExistingFile(dataStorage.getIntegerTracker(), argsProcessor.getIntegerFile());
                FileProcessor.saveToExistingFile(dataStorage.getFloatTracker(), argsProcessor.getFloatsFile());
            } else {
                FileProcessor.saveToNewFile(dataStorage.getStringTracker(), argsProcessor.getStringFile());
                FileProcessor.saveToNewFile(dataStorage.getIntegerTracker(), argsProcessor.getIntegerFile());
                FileProcessor.saveToNewFile(dataStorage.getFloatTracker(), argsProcessor.getFloatsFile());
            }
        } catch (FileSystemException fileSystemException) {
            System.out.println(fileSystemException.getMessage());
            System.exit(0);
        }

        if (argsProcessor.isOutputShortStatistics()){
            System.out.printf("Number of elements recorded in %s = %d \n", argsProcessor.getStringFile().getName(), dataStorage.getStringTracker().getElements().size());
            System.out.printf("Number of elements recorded in %s = %d \n", argsProcessor.getIntegerFile().getName(), dataStorage.getIntegerTracker().getElements().size());
            System.out.printf("Number of elements recorded in %s = %d \n", argsProcessor.getFloatsFile().getName(), dataStorage.getFloatTracker().getElements().size());
        } else if (argsProcessor.isOutputFullStatistics()) {
            System.out.println("Strings statistics");
            System.out.printf("Number of elements recorded in %s = %d \n", argsProcessor.getStringFile().getName(), dataStorage.getStringTracker().getElements().size());
            System.out.printf("Shortest string size = %d \n", dataStorage.getStringTracker().getMin().toString().length());
            System.out.printf("Longest string size = %d \n", dataStorage.getStringTracker().getMax().toString().length());

            System.out.println("Integers statistics");
            System.out.printf("Number of elements recorded in %s = %d \n", argsProcessor.getIntegerFile().getName(), dataStorage.getIntegerTracker().getElements().size());
            System.out.printf("Minimum integer = %s \n", dataStorage.getIntegerTracker().getMin());
            System.out.printf("Maximum integer = %s \n", dataStorage.getIntegerTracker().getMax());
            System.out.printf("Sum of integers = %s \n", dataStorage.getIntegerTracker().getSum());
            long integerSum = Long.parseLong(dataStorage.getIntegerTracker().getSum());
            double avgInt = (double) integerSum / dataStorage.getIntegerTracker().getElements().size();
            System.out.printf("Average of integers = %f \n", avgInt);

            System.out.println("Floats statistics");
            System.out.printf("Number of elements recorded in %s = %d \n", argsProcessor.getFloatsFile().getName(), dataStorage.getFloatTracker().getElements().size());
            System.out.printf("Minimum float = %s \n", dataStorage.getFloatTracker().getMin());
            System.out.printf("Maximum float = %s \n", dataStorage.getFloatTracker().getMax());
            System.out.printf("Sum of floats = %s \n", dataStorage.getFloatTracker().getSum());
            double doubleSum = Double.parseDouble(dataStorage.getFloatTracker().getSum());
            double avgFloat = doubleSum / dataStorage.getFloatTracker().getElements().size();
            System.out.printf("Average of floats = %f \n", avgFloat);
        }
    }

}

