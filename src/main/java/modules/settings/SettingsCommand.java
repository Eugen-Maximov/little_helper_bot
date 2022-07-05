package modules.settings;

import main.bot_users.BotUser;
import main.CommandService;
import data.Messages;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static main.bot_users.UsersContainer.getUser;

public class SettingsCommand extends CommandService {

    public SettingsCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User tgUser, Chat chat, String[] strings) {
        BotUser user = getUser(tgUser);
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user, Messages.Settings.startSettingsMessage);
    }
}
