
/**
 * FileOperationsDynamic.java
 *
 * A dynamic Java program for performing file operations:
 * 1. Write to a file
 * 2. Read from a file
 * 3. Modify the content of a file
 *
 * Input is taken from the user for file path, content, and modification.
 *
 * Author: Mayur Aglwe
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileOperationsDyanamic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the full file path (e.g., sample.txt or C:\\\\files\\\\sample.txt): ");
        String filePath = scanner.nextLine();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Write to file");
            System.out.println("2. Read from file");
            System.out.println("3. Modify file content");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter content to write (will overwrite file):");
                        String content = scanner.nextLine();
                        writeToFile(filePath, content);
                        System.out.println("✅ Content written successfully.");
                        break;

                    case 2:
                        System.out.println("📄 Reading file content:");
                        readFile(filePath);
                        break;

                    case 3:
                        System.out.print("Enter word to be replaced: ");
                        String target = scanner.nextLine();
                        System.out.print("Enter replacement word: ");
                        String replacement = scanner.nextLine();
                        modifyFile(filePath, target, replacement);
                        System.out.println("✅ File content modified successfully.");
                        break;

                    case 4:
                        System.out.println("👋 Exiting program.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("❌ Invalid choice. Try again.");
                }
            } catch (IOException e) {
                System.err.println("⚠️ Error: " + e.getMessage());
            }
        }
    }

    public static void writeToFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    public static void readFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("❌ File does not exist.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber++ + ": " + line);
            }
        }
    }

    public static void modifyFile(String filePath, String target, String replacement) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("❌ File does not exist.");
            return;
        }

        List<String> lines = Files.readAllLines(path);
        List<String> modifiedLines = new ArrayList<>();

        for (String line : lines) {
            modifiedLines.add(line.replaceAll(target, replacement));
        }

        Files.write(path, modifiedLines);
    }
}
