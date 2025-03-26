package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceFileReader {
    private static volatile ResourceFileReader instance;
    private final Properties configProperties;

    private ResourceFileReader() {
        configProperties = new Properties();
        loadConfiguration();
    }

    private void loadConfiguration() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config/config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found in resources folder.");
            }
            configProperties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties: " + e.getMessage());
        }
    }

    public static ResourceFileReader getInstance() {
        if (instance == null) {
            synchronized (ResourceFileReader.class) {
                if (instance == null) {
                    instance = new ResourceFileReader();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        String value = configProperties.getProperty(key);
        System.out.println(value);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties.");
        }
        return value;
    }
}
