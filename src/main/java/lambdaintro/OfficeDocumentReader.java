package lambdaintro;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {

    private final List<String> EXTENSIONS = List.of("docx", "pptx", "xlsx");

    public List<File> listOfficeDocuments(File path) {
        List<File> files = new ArrayList<>();
        File[] filesArray = path.listFiles();
        for (File item : filesArray) {
            if (!item.isDirectory() && isContainsAny(item.toString())) {
                files.add(item);
            }
        }
        files.sort(Comparator.comparing(File::toString));
        return files;
    }

    private boolean isContainsAny(String s) {
        for (String item : EXTENSIONS) {
            if (s.toLowerCase().endsWith(item)) {
                return true;
            }
        }
        return false;
    }

}
