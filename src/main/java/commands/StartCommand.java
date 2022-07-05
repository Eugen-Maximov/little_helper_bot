package commands;

import data.KeyboardButtons;
import data.Messages;
import main.CommandService;
import main.bot_users.BotUser;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.bot_users.UsersContainer.getUser;
import static main.bot_users.UsersContainer.isHasUser;


public class StartCommand extends CommandService {

    public StartCommand(String command, String description) {
        super(command, description);
    }

//    public final List<KeyboardButtons> startButtons = Arrays.asList(
//            KeyboardButtons.HELP_BUTTON,
//            KeyboardButtons.WEATHER_BUTTON
//    );

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

    private void createMessage(AbsSender absSender, BotUser user, Chat chat, String[] strings) {

    }
}
