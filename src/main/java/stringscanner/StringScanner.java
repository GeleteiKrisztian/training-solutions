package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {
        isEmptyOrNull(intString);
        Scanner scanner = new Scanner(intString);

        if(delimiter == null && !intString.contains(" ")) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }

        if (delimiter == null && intString.contains(" ")) {
            scanner.useDelimiter(" ");
        } else {
            scanner.useDelimiter(delimiter);
        }

        int totalSum = 0;

        try {
            while (scanner.hasNext()) {
                totalSum += scanner.nextInt();
            }
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        return totalSum;
    }

    public int readAndSumValues(String intString) {
        isEmptyOrNull(intString);
        Scanner scanner = new Scanner(intString);
        int totalSum = 0;
        while (scanner.hasNextInt()) {
            totalSum += scanner.nextInt();
        }
        return totalSum;
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        isEmptyOrNull(text);
        isEmptyOrNull(word);
        String line = "";
        Scanner scanner = new Scanner(text);
        while (scanner.hasNextLine()) {
            String loopLine = scanner.nextLine();
                if (loopLine.contains(word)) {
                    line += loopLine + "\n";
                }
        }
        return "".equals(line.length()) ? null : line;
    }

    private boolean isEmptyOrNull(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        return false;
    }

}
