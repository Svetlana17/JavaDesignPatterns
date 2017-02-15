package singleton;

import java.util.Map;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {
        Properties properties = PropertiesHolder.getInstance().getProperties();
        System.out.println("First access:");
        for (Map.Entry property : properties.entrySet()) {
            System.out.printf("%s = %s\n", property.getKey(), property.getValue());
        }
        System.out.println();
        System.out.println("Second access:");
        System.out.printf("Same instance = %s", properties == PropertiesHolder.getInstance().getProperties());
    }
}
