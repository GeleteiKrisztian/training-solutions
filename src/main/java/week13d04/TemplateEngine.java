package week13d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class TemplateEngine {

    public void merge(BufferedReader reader, Map<String, Object> map, BufferedWriter writer) {

        try(reader; writer) {
            String line;
            while ((line = reader.readLine()) != null) {
                int firstIndex = line.indexOf("{");
                int lastIndex = line.indexOf("}", firstIndex);
                if (firstIndex != -1) {
                    String partToReplace = line.substring(firstIndex + 1, lastIndex);
                    String newLine = line.replace("{" + partToReplace + "}", map.get(partToReplace).toString());
                    writer.write(newLine + "\n");
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

}
