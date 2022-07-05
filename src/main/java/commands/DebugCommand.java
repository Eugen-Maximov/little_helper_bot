package commands;

import main.CommandService;
import main.bot_users.BotUser;
import main.bot_users.UsersContainer;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Arrays;

import static main.bot_users.UsersContainer.getUser;
import static helpers.InputHelper.getActualStatus;

public class DebugCommand extends CommandService {

    private BotUser user;
    private String debug;


    public DebugCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User tgUser, Chat chat, String[] strings) {
        this.user = getUser(tgUser);
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user, /*"debug");*/debugMessage(tgUser));
    }

    private String debugMessage(User tgUser) {
        return Arrays.toString(
                new String[]{"Lat-lon:" + Arrays.toString(user.getUserLocation())}) + "\n"
                + "userLocale: " + user.getUserLocale() + "\n"
                + "userRegion: " + user.getUserRegion() + "\n"
                + "firstName: " + user.getUserFirstName() + "\n"
                + "userLastName: " + user.getUserLastName() + "\n"
                + "Username: " + user.getUserUsername() + "\n"
                + "class: " + user.getClass() + "\n"
                + "tgUser:" + UsersContainer.getUser(tgUser) + "\n\n"
                + "userInputStatus: " + getActualStatus(user);
    }
}
