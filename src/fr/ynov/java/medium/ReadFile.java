package fr.ynov.java.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ReadFile {

    public static String readFile(String fileName) {
        String fileContent="";
        try {
            File openedFile = new File(fileName);
            Scanner reader = new Scanner(openedFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                fileContent += data + "\n";
                System.out.println(data);
            }
            System.out.println();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fileContent;
    }

    public static boolean createFile(String filePath){
        try {
            File newFile = new File(filePath);
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
                return true;
            } else {
                System.out.println("File already exists.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public static void createDirectory(String directoryName){
        try {
            File newDir = new File(directoryName);
            if (newDir.mkdirs()) {
                System.out.println("Directory created: " + newDir.getName());
            } else {
                System.out.println("Directory already exists.");
            }
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readAllFiles(String dirPath) {
        File directory = new File(dirPath);
        if (directory.isDirectory()){
            File[] files=directory.listFiles();
            if (files.length>0) {
                for (File file : files) {
                    if (file.isFile()) {
                        readFile(file.getPath());
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else{
            System.out.println("The provided path is not a valid directory.");
        }
    }

    public static void writeToFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
            System.out.println("Successfully wrote to file.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.\n");
            e.printStackTrace();
        }
    }

    public static boolean copyFile(String filePath){
        File copy = new File(filePath);
        if(createFile(copy.getParentFile()+"\\copy-of-"+copy.getName())){
            writeToFile(copy.getParentFile()+"\\copy-of-"+copy.getName(),readFile(filePath));
            System.out.println("Copy of file made.\n");
            return true;
        }
        System.out.println("An Error occurred.\n");
        return false;
    }

    public static void main(String[] args) {
        copyFile("src/fr/ynov/java/medium/test/test1.txt");
        readAllFiles("./src/fr/ynov/java/medium/test");
    }

}
