import commands.NoCommand;
import commands.default_commands.HelpCommand;
import commands.default_commands.StartCommand;
import commands.WeatherCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingCommandBot {

    private final String BOT_NAME;
    private final String BOT_TOKEN;

    private final NoCommand noCommand;



    public Bot() {
        this.BOT_NAME = "Dex";
        this.BOT_TOKEN = System.getenv("BOT_TOKEN");
        this.noCommand = new NoCommand();
        register(new StartCommand("start", "start"));
        register(new HelpCommand("help", "help"));
        register(new WeatherCommand("weather", "actual weather"));
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
        Long userId = getUserId(msg);

        String answer = noCommand.nonCommandExecute(chatId, userId, msg.getText());
        setAnswer(chatId, userId, answer);
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    private Long getUserId(Message msg) {
        return msg.getFrom().getId();
    }

    private void setAnswer(Long chatId, Long userId, String text) {
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
