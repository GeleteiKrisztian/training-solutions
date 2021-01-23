package iostringwriter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    public static final int SIZE = 1000;
    private List<byte[]> byteArrays = new ArrayList<>();

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(byteArrays);
    }

    public void readBytesAndCreateMatrix(String file) {
        try (InputStream is = new BufferedInputStream(Files.newInputStream(Path.of(file)))) {
            byte[] bytes = new byte[SIZE];
            int size;
            while ((size = is.read(bytes)) > 0) {
               byteArrays.add(bytes);
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < byteArrays.size(); j++) {
                if (byteArrays.get(j)[i] == '0') {
                    ++zeros;
                } else {
                    ++ones;
                }
            }
            if (zeros > ones) {
                ++counter;
            }
        }
        return counter;
    }
}
