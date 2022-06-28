import data.bot_users.BotUser;
import default_commands.DebugCommand;
import default_commands.HelpCommand;
import default_commands.NoCommand;
import default_commands.StartCommand;
import modules.weather.WeatherCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static data.Environments.TELEGRAM_TOKEN;
import static data.bot_users.UsersContainer.getUser;

public class Bot extends TelegramLongPollingCommandBot {

    private final String BOT_NAME;
    private final String BOT_TOKEN;

    private final NoCommand noCommand;

    public Bot() {
        this.BOT_NAME = "Dex";
        this.BOT_TOKEN = System.getenv(TELEGRAM_TOKEN.getEnvName());
        this.noCommand = new NoCommand();
        register(new StartCommand("start", "start"));
        register(new HelpCommand("help", "help"));
        //register(new SettingsCommand("settings", "settings"));
        register(new WeatherCommand("weather", "actual weather"));
        register(new DebugCommand("d", "debug"));
        getRegisteredCommands();
    }

    @Override
    public void onClosing() {
        super.onClosing();
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        Long chatId = msg.getChatId();
        BotUser user = getUser(msg.getFrom());
        String answer = noCommand.nonCommandExecute(chatId, user, msg);
        setAnswer(chatId, user, answer);
    }

    @Override
    public void onRegister() {
        super.onRegister();
        //this.user = new BotUser();
    }

    private void setAnswer(Long chatId, BotUser user, String text) {
        SendMessage answer = new SendMessage();
        answer.setText(text);
        answer.setChatId(chatId.toString());
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
