package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommandArgsProcessor {
    private String savePath = "";
    private String filePrefix = "";
    private final List<String> txtFiles = new ArrayList<>();

    private File stringFile;
    private File integerFile;
    private File floatsFile;

    private boolean useExistFile = false;
    private boolean outputShortStatistics = false;
    private boolean outputFullStatistics = false;

    public void processArgs(String[] args) {
        for(int i = 0; i < args.length; i ++){
            if(args[i].startsWith("-")){
                try{
                    switch (args[i]){
                        case "-o":
                            savePath = args[i+1] + File.separator;
                            break;
                        case "-p":
                            filePrefix = args[i+1];
                            break;
                        case "-a":
                            useExistFile = true;
                            break;
                        case "-s":
                            outputShortStatistics = true;
                            break;
                        case "-f":
                            outputFullStatistics = true;
                            break;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    throw new ArrayIndexOutOfBoundsException("Неправильно указаны параметры!");
                }
            } else if(args[i].endsWith(".txt")){
                txtFiles.add(args[i]);
            }
        }

        stringFile = new File(savePath + filePrefix + "string.txt");
        integerFile = new File(savePath + filePrefix + "integers.txt");
        floatsFile = new File(savePath + filePrefix + "floats.txt");
    }

    public List<String> getTxtFiles(){
        return txtFiles;
    }
    public File getStringFile(){
        return stringFile;
    }
    public File getIntegerFile(){
        return integerFile;
    }
    public File getFloatsFile(){
        return floatsFile;
    }

    public boolean isTxtFilesExists(){
        return !txtFiles.isEmpty();
    }
    public boolean isUseExistFile(){
        return  useExistFile;
    }
    public boolean isOutputShortStatistics(){
        return outputShortStatistics;
    }
    public boolean isOutputFullStatistics(){
        return outputFullStatistics;
    }
}
