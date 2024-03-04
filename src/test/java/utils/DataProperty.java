package utils;

import java.io.InputStream;
import java.util.Properties;

public class DataProperty {

        private static final String CONFIG_FILE = "data.properties";
        private static Properties properties;

        static {
            properties = new Properties();
            try (InputStream input = utils.DataProperty.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
                if (input == null) {
                    System.out.println("Sorry, unable to find " + CONFIG_FILE);
                }
                properties.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public String getHost() {
        return properties.getProperty("HOST");
    }
    public String getBrowser() {
        return properties.getProperty("BROWSER");
    }
    public String getEnvironment() {
        return properties.getProperty("ENV");
    }
    public String getLoginErrorMessage() {
        return properties.getProperty("LOGIN_ERROR_MESSAGE").replace("?","ı");

    }
    public String getTotalLinksCount() {
        return properties.getProperty("TOTAL_LINKS_COUNT");
    }


}


