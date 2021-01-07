package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                for (int i = 11; i < 16; i++) {
                    ++numbers[Integer.parseInt(split[i]) -1];
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    public int getNumber(int num) {
        return numbers[num-1];
    }

}
