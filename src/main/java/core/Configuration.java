package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import static utils.Constants.*;

public class Configuration {
    private static String testDataFileName = "default";
    private static String URL = System.getenv("URL");
    private static String BROWSER = System.getenv("BROWSER");
    private static String LOGIN = System.getenv("LOGIN");
    private static String PASSWORD = System.getenv("PASSWORD");

    public static void setTestDataLanguage(String language) {
        if (language.equalsIgnoreCase(EN))
            testDataFileName = TEST_DATA_FILE_NAME_EN;
        else if (language.equalsIgnoreCase(FR))
            testDataFileName = TEST_DATA_FILE_NAME_FR;
        else
            System.out.println("Language do not set upped");
    }

    public static String getTestDataByName(String propertyKey) {
        String propertyValue = "";
        String propertyFileName = System.getProperty("user.dir") + File.separator + "src" +
                File.separator + "main" + File.separator + "resources" + File.separator + testDataFileName;
        try (InputStream input = new FileInputStream(propertyFileName)) {
            Properties prop = new Properties();
            prop.load(input);
            propertyValue = prop.getProperty(propertyKey);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File name not found - " + propertyFileName);
        }
        return propertyValue;
    }

    public static String getURL() {
        return Optional.ofNullable(URL).orElse(getTestDataByName("url"));
    }

    public static String getBrowser() {
        return Optional.ofNullable(BROWSER).orElse(getTestDataByName("browser"));
    }

    public static String getLogin() {
        return Optional.ofNullable(LOGIN).orElse(getTestDataByName("login"));
    }

    public static String getPassword() {
        return Optional.ofNullable(PASSWORD).orElse(getTestDataByName("password"));
    }
}
