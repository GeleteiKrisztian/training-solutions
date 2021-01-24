package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] bytes, Path path) {
        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(path.resolve("image.png")))) {
            for (int i = 0; i < bytes.length; i++) {
                for (int j = 0; j < bytes[i].length; j++) {
                    outputStream.write(bytes[i][j]);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }
}
