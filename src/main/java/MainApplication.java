import helpers.LogHelper;
import main.Bot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.logging.Logger;

import static helpers.LogHelper.SESSION_ID;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

public class MainApplication {

    static Logger LOGGER = LogHelper.LOGGER;

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot());
            LOGGER.log(INFO, "Start bot application" + SESSION_ID);
        } catch (TelegramApiException e) {
            LOGGER.log(SEVERE, "TGApi troubles" + SESSION_ID, e);
            e.printStackTrace();
        }
    }
}
