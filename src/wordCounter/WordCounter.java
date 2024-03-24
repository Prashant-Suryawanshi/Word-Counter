package wordCounter;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static int countWords(String text) {
        String[] words = text.split("\\b\\W+\\b");
        
        int wordCount = 0;
        
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        
        return wordCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter 'text' to input text, 'file' to input file, or 'exit' to quit: ");
            String option = scanner.nextLine().trim().toLowerCase();
            
            switch (option) {
                case "text":
                    System.out.print("Enter your text: ");
                    String inputText = scanner.nextLine();
                    int wordCount = countWords(inputText);
                    System.out.println("Total words in the text: " + wordCount);
                    break;
                case "file":
                    System.out.print("Enter the path to the file: ");
                    String filePath = scanner.nextLine().trim();
                    try {
                        File file = new File(filePath);
                        Scanner fileScanner = new Scanner(file);
                        StringBuilder fileContent = new StringBuilder();
                        while (fileScanner.hasNextLine()) {
                            fileContent.append(fileScanner.nextLine());
                        }
                        fileScanner.close();
                        wordCount = countWords(fileContent.toString());
                        System.out.println("Total words in the file: " + wordCount);
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                    }
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please enter 'text', 'file', or 'exit'.");
                    break;
            }
        }

        scanner.close();
    }
}
