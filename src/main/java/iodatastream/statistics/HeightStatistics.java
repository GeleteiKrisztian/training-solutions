package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {

    public void saveHeights(List<Integer> height, Path file) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            dos.writeInt(height.size());
            for (Integer item : height) {
                dos.writeInt(item);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't write the file.",ioe);
        }
    }

}
