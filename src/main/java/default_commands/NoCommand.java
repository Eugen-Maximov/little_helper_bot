package default_commands;

import data.bot_users.BotUser;
import org.telegram.telegrambots.meta.api.objects.Message;

import static helpers.InputHelper.input;


public class NoCommand {

    public String nonCommandExecute(Long chatId, BotUser user, Message message) {
        return input(message, user);
    }
}
