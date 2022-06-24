package default_commands;

import data.Messages;
import data.bot_users.BotUser;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static data.bot_users.UsersContainer.getUser;
import static data.bot_users.UsersContainer.isHasUser;


public class StartCommand extends CommandService {

    public StartCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User tgUser, Chat chat, String[] strings) {
        BotUser user;
        if (!isHasUser(tgUser)) {
            user = new BotUser().registerUser(tgUser);
        } else {
            user = getUser(tgUser);
        }
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user, Messages.startMessage);
    }

    private void createMessage(AbsSender absSender, BotUser user, Chat chat, String[] strings)  {

    }
}
