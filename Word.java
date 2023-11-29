package task3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Word {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text or provide a file path:");
        String input = scanner.nextLine();
        String content = "";

        if (input.endsWith(".txt")) {
            content = readFile(input);
        } else {
            content = input;
        }
        String[] words = content.split("\\s+|[,.;:!?()'\"]");

        int wordCount = 0;
        String[] commonWords = {"the", "and", "is", "in", "to", "of", "a"};

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!isCommonWord(word, commonWords)) {
                wordCount++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Total number of words: " + wordCount);

        System.out.println("Number of unique words: " + wordFrequency.size());
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return content.toString();
    }

    private static boolean isCommonWord(String word, String[] commonWords) {
        for (String common : commonWords) {
            if (word.equalsIgnoreCase(common)) {
                return true;
            }
        }
        return false;
    }
}


