package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public final String REPLACE_CHAR = "*";

    public String createHistogram(BufferedReader buffReader) {
        try(BufferedReader br = buffReader) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line);
                for (int i = 0; i < num; i++) {
                    sb.append(REPLACE_CHAR);
                }
                sb.append("\n");
            }
            return sb.toString();
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read the file.", ioe);
        }
    }
}
