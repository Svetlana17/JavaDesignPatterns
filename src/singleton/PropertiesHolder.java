package singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHolder {

    private static PropertiesHolder instance;

    private final Properties properties;

    public static PropertiesHolder getInstance() {
        if (instance == null) {
            instance = new PropertiesHolder();
        }
        return instance;
    }

    private PropertiesHolder() {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("resources\\config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
