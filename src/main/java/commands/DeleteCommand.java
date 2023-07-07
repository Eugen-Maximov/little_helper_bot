package commands;

import main.CommandService;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static data.KeyboardButtons.getMainMenu;
import static helpers.NotesController.deleteUserNote;

public class DeleteCommand extends CommandService {

    public DeleteCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        sendAnswer(
                absSender,
                chat.getId(),
                this.getCommandIdentifier(),
                user,
                deleteUserNote(user, strings),
                getMainMenu()
        );
    }
}
