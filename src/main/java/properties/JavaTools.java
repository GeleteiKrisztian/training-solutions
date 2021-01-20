package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {
    private Properties properties = new Properties();

    public JavaTools() {
        try(InputStream is = JavaTools.class.getResourceAsStream("/javatools.properties")) {
            properties.load(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> res = new HashSet<>();
        for (String item : properties.stringPropertyNames()) {
            String [] split = item.split("\\.");
            res.add(split[0]);
        }
        return res;
    }

    public Set<String> getTools() {
        Set<String> tools = new HashSet<>();
        for (String item : properties.stringPropertyNames()) {
            if (item.contains("name")) {
                tools.add(properties.getProperty(item));
            }
        }
        return tools;
    }

    public String getName(String s) {
        return properties.getProperty(s + ".name");
    }

    String getUrl(String s) {
        return properties.getProperty(s + ".url");
    }
}
