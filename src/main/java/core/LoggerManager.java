package core;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerManager {
    private static Logger LOGGER = Logger.getLogger(LoggerManager.class.getName());

    public static void log(String message) {
        LOGGER.log(Level.INFO, message);
    }
}
