/**
 * FileOperationsDemo.java
 *
 * This Java program demonstrates how to:
 * 1. Write to a file.
 * 2. Read from a file.
 * 3. Modify the file content.
 *
 * Author: Mayur Aglwe
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileOperationsDemo {

    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        try {
            // Step 1: Write to the file
            writeToFile("Hello, this is the original content of the file.\nJava is powerful!\n");

            // Step 2: Read and display the file
            System.out.println("Original File Content:");
            readFile();

            // Step 3: Modify the content (replace "Java" with "Java Programming")
            modifyFile("Java", "Java Programming");

            // Step 4: Read again to show modified content
            System.out.println("\nModified File Content:");
            readFile();

        } catch (IOException e) {
            System.err.println("Error during file operations: " + e.getMessage());
        }
    }

    /**
     * Writes the given content to a file.
     * If the file exists, it will be overwritten.
     */
    public static void writeToFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
        }
    }

    /**
     * Reads and prints the content of the file.
     */
    public static void readFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    /**
     * Modifies the file by replacing all occurrences of a target word with a replacement word.
     * The file is read line by line, modified, and then written back.
     */
    public static void modifyFile(String target, String replacement) throws IOException {
        Path path = Paths.get(FILE_PATH);
        List<String> lines = Files.readAllLines(path);

        List<String> modifiedLines = new ArrayList<>();
        for (String line : lines) {
            modifiedLines.add(line.replaceAll(target, replacement));
        }

        Files.write(path, modifiedLines);
    }
}
