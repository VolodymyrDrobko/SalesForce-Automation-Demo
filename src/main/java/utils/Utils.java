package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {
    public static String getCurrentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String date = localDateTime.format(formatter);
        return date;
    }

    public static void waitForCondition(WebDriver driver, int timeoutSeconds, int retry, Function cause) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(retry, TimeUnit.SECONDS)
                .ignoring(Exception.class);

        wait.until(cause);
    }
}
