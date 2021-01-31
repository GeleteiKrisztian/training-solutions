package week08d05;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Plane {

    public int calculateLongestOceanPart(Path file) {
        int maxLength = 0;
        int counter = 0;
        try (InputStream reader = Files.newInputStream(file)) {
            int num;
            while ((num = reader.read()) != -1) {
                char ch = (char) num;
                if (ch == '1') {
                    if (counter > 0 && counter > maxLength) {
                        maxLength = counter;
                    }
                    counter = 0;
                }
                if (ch != '1') {
                    counter++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read the file.", ioe);
        }
        return maxLength;
    }

}
