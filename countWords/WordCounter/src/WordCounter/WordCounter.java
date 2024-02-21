package WordCounter;

import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
    	String inputFile = "C:\\Users\\antho\\OneDrive\\java stuff\\countWords\\WordCounter\\src\\WordCounter\\input";
    	String outputFile = "C:\\Users\\antho\\OneDrive\\java stuff\\countWords\\WordCounter\\src\\WordCounter\\output";


        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase(); // Convert to lowercase for case insensitivity
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to the output file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
