import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.testng.annotations.Test;

public class HealthCheckTest {

    @Test
    public void testHealthCheck() {
        try {
            new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            throw new AssertionError(e);
        }
    }
}
