package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesFile {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();

            File file = new File("src/main/resources/config.properties");
            FileInputStream stream = new FileInputStream(file);

            properties.load(stream);
            stream.close();

            String name = properties.getProperty("my.name", "no valid name given");
            System.out.println("name = " + name);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

