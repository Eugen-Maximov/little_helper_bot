package commands;

import data.Texts;
import main.CommandService;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static data.Database.clearNotes;

public class ClearCommand extends CommandService {

    public ClearCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        clearNotes(user);
        sendAnswer(
                absSender,
                chat.getId(),
                this.getCommandIdentifier(),
                user,
                Texts.CLEAR_MESSAGE
        );
    }
}
