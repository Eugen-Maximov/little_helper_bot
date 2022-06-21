package commands.default_commands;

import commands.CommandService;
import data.Messages;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;



public class StartCommand extends CommandService {

    public StartCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        Long userId = user.getId();
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userId, Messages.startMessage);
    }
}
