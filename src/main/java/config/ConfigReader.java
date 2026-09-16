package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "config.properties file was not found"
                );
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load config.properties",
                    e
            );
        }
    }

    private ConfigReader() {
        // Prevent object creation
    }

    public static String get(String key) {

        String systemValue = System.getProperty(key);

        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Configuration key not found: " + key
            );
        }

        return value;
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}