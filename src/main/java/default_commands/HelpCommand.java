package default_commands;

import data.Messages;
import data.bot_users.BotUser;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static data.bot_users.UsersContainer.getUser;


public class HelpCommand extends CommandService {

    public HelpCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User tgUser, Chat chat, String[] strings) {
        BotUser user = getUser(tgUser);
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user, Messages.helpMessage);
    }
}
