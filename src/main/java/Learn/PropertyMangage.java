package Learn;

import java.io.IOException;
import java.util.Properties;

public class PropertyMangage {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(PropertyMangage.class.getClassLoader().getResourceAsStream("Config"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String get(String input) {


        return (String) properties.get(input);
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
