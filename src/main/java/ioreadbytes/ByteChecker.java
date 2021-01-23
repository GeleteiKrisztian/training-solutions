package ioreadbytes;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public static final char CHARTOFIND = 'A';

    public int readBytesAndFindAs(String file) {

        try (InputStream is = new BufferedInputStream(Files.newInputStream(Path.of(file)))) {
            byte[] bytes = new byte[2000];
            int counter = 0;
            int size;
            StringBuilder sb = new StringBuilder();
            while ((size = is.read(bytes)) > 0) {
                sb.append(new String(bytes, StandardCharsets.UTF_8));
            }
            String s = sb.toString();
            for (int i = 0; i < s.length() ; i++) {
                char c = s.charAt(i);
                if (c == CHARTOFIND) {
                    ++counter;
                }
            }
            return counter;
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

}
