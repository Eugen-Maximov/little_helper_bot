package main;

import helpers.LogHelper;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.logging.Logger;

import static data.Texts.UNREGISTERED_USER_TEXT;
import static helpers.AllowedUsersHelper.ifAdmin;
import static helpers.LogHelper.SESSION_ID;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;


public abstract class CommandService extends BotCommand {

    static Logger LOGGER = LogHelper.LOGGER;
    private SendMessage message;

    public CommandService(String command, String description) {
        super(command, description);
    }

    protected void sendAnswer(AbsSender sender, Long chatId, String commandName, User user, String text) {
        message = setupAnswer(chatId, user, text);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            LOGGER.log(SEVERE, "TGApi troubles" + SESSION_ID, e);
            e.printStackTrace();
        }
    }

    protected void sendAnswer(AbsSender sender, Long chatId, String commandName, User user, String text, List<KeyboardButton> buttons) {
        message = setupAnswer(chatId, user, text);
        message.setReplyMarkup(new ReplyKeyboardMaker().createKeyboard(buttons));
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            LOGGER.log(SEVERE, "TGApi troubles" + SESSION_ID, e);
            e.printStackTrace();
        }
    }

    protected void sendAnswer(AbsSender sender, Long chatId, String commandName, User user, String text, ReplyKeyboardMarkup keyboard) {
        message = setupAnswer(chatId, user, text);
        message.setReplyMarkup(keyboard);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            LOGGER.log(SEVERE, "TGApi troubles" + SESSION_ID, e);
            e.printStackTrace();
        }
    }

    private SendMessage setupAnswer(Long chatId, User user, String text) {
        SendMessage newMessage = new SendMessage();
        newMessage.enableMarkdown(true);
        newMessage.setChatId(chatId.toString());
        if (ifAdmin(user)) {
            newMessage.setText(text);
        } else {
            LOGGER.log(WARNING, "Attempt to access the bot from outside user: " + user + SESSION_ID);
            newMessage.setText(UNREGISTERED_USER_TEXT);
        }
        return newMessage;
    }
}
