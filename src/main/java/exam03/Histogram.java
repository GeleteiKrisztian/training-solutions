package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public final String REPLACE_CHAR = "*";

    public String createHistogram(BufferedReader Buffreader) {
        try(BufferedReader br = Buffreader) {
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line);
                for (int i = 0; i < num; i++) {
                    result += REPLACE_CHAR;
                }
                result += "\n";
            }
            return result;
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read the file.", ioe);
        }
    }
}
