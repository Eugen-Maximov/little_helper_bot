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

import static helpers.LogHelper.SESSION_ID;
import static java.util.logging.Level.SEVERE;


public abstract class CommandService extends BotCommand {

    static Logger LOGGER = LogHelper.LOGGER;

    public CommandService(String command, String description) {
        super(command, description);
    }

    protected void sendAnswer(AbsSender sender, Long chatId, String commandName, User user, String text) {
        SendMessage message = new SendMessage();
        //включаем поддержку режима разметки, чтобы управлять отображением текста и добавлять эмодзи
        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            LOGGER.log(SEVERE, "TGApi troubles" + SESSION_ID, e);
            e.printStackTrace();
        }
    }

    protected void sendAnswer(AbsSender sender, Long chatId, String commandName, User user, String text, List<KeyboardButton> buttons) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        message.setReplyMarkup(new ReplyKeyboardMaker().createKeyboard(buttons));
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            LOGGER.log(SEVERE, "TGApi troubles" + SESSION_ID, e);
            e.printStackTrace();
        }
    }

    protected void sendAnswer(AbsSender sender, Long chatId, String commandName, User user, String text, ReplyKeyboardMarkup keyboard) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        message.setReplyMarkup(keyboard);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            LOGGER.log(SEVERE, "TGApi troubles" + SESSION_ID, e);
            e.printStackTrace();
        }
    }
}
