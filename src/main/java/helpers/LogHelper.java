package helpers;


import java.io.InputStream;
import java.util.UUID;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class LogHelper {

    public static final String SESSION_ID = "\nSESSION_ID: " + UUID.randomUUID() + "\n";
    public static Logger LOGGER;

    static {
        try (InputStream ins = LogHelper.class.getClassLoader().getResourceAsStream("log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(LogHelper.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
