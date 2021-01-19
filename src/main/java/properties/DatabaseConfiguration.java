package properties;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class DatabaseConfiguration {
    private final String ENCODING = "UTF-8";
    private Properties properties = new Properties();

    public DatabaseConfiguration() {
        try (InputStream is = DatabaseConfiguration.class.getResourceAsStream("/db.properties");InputStreamReader isr = new InputStreamReader(is, ENCODING)) {
            properties.load(isr);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file", e);
        }
    }

    public DatabaseConfiguration(File file) {

        try (FileInputStream fis = new FileInputStream(file); InputStreamReader isr = new InputStreamReader(fis, Charset.forName(ENCODING))) {
            properties.load(isr);

        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file", e);
        }
    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }

}
