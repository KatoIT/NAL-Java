package binaryFileAndSerialization;

import java.io.*;
import java.util.Scanner;

public class CopyFile {

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source);
             OutputStream os = new FileOutputStream(dest)
        ) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.print("Enter destination file:");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingStream(sourceFile, destFile);
            System.out.print("Copy completed");
        } catch (IOException ioe) {
            System.out.print("Can't copy that file");
            System.out.print(ioe.getMessage());
        }
    }
}
