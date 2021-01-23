package iostringwriter;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    private void writer(Writer writer, List<String> words) {
        try(writer) {
            for (String item : words) {
                writer.write(item + " " + item.length() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    public String writeWithStringWriter(List<String> words) {
        StringWriter sw = new StringWriter();
        writer(sw, words);
        return sw.toString();
    }
}
