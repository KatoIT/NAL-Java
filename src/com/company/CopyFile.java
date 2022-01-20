package com.company;

import java.io.*;
import java.util.ArrayList;

public class CopyFile {
    public static ArrayList<String> readFile(String filePath) {
        ArrayList<String> contentFile = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException("File not found");
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                contentFile.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return contentFile;
    }

    public static void writeFile(String filePath, ArrayList<String> contentFile) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                throw new FileAlreadyExist("File already exist");
            }
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String str :
                    contentFile) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileAlreadyExist e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ArrayList<String> content = readFile("file.txt");
        writeFile("file2.txt", content);
    }

}

class FileAlreadyExist extends Exception{
    public FileAlreadyExist(String message) {
        super(message);
    }
}