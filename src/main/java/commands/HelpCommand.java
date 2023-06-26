package commands;

import data.Texts;
import main.CommandService;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;


public class HelpCommand extends CommandService {

    public HelpCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        sendAnswer(
                absSender,
                chat.getId(),
                this.getCommandIdentifier(),
                user,
                Texts.HELP_MESSAGE
        );
    }
}
