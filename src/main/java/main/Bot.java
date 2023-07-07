package main;

import commands.ClearCommand;
import commands.HelpCommand;
import commands.NoCommand;
import commands.StartCommand;
import helpers.LogHelper;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Logger;

import static data.Environments.TELEGRAM_TOKEN;
import static data.Environments.getEnvValue;
import static data.Texts.UNREGISTERED_USER_TEXT;
import static helpers.AllowedUsersHelper.ifAdmin;
import static helpers.LogHelper.SESSION_ID;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;

public class Bot extends TelegramLongPollingCommandBot {

    static Logger LOGGER = LogHelper.LOGGER;

    private final String BOT_NAME;
    private final String BOT_TOKEN;

    private final NoCommand noCommand;

    public Bot() {
        this.BOT_NAME = "Little Helper Bot";
        this.BOT_TOKEN = getEnvValue(TELEGRAM_TOKEN);
        this.noCommand = new NoCommand();
        register(new StartCommand("start", "start bot"));
        register(new HelpCommand("help", "FAQ"));
        register(new ClearCommand("clear", "⚠️Clear all notes⚠️"));
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
        SendMessage answer = noCommand.noCommandExecute(chatId, msg.getFrom(), msg);
        if (ifAdmin(msg.getFrom())) {
            setAnswer(chatId, msg.getFrom(), answer);
        } else {
            LOGGER.log(WARNING, "Attempt to access the bot from outside user: " + msg.getFrom() + SESSION_ID);
            setAnswer(chatId, msg.getFrom(), UNREGISTERED_USER_TEXT);
        }
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    public void setAnswer(Long chatId, User user, String text) {
        SendMessage answer = new SendMessage();
        answer.setText(text);
        answer.setChatId(chatId.toString());
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            LOGGER.log(SEVERE, "TGApi troubles" + SESSION_ID, e);
            e.printStackTrace();
        }
    }

    public void setAnswer(Long chatId, User user, SendMessage answer) {
        answer.setChatId(chatId.toString());
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
