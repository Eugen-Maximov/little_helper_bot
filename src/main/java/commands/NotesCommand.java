package commands;

import main.CommandService;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static api.NotionController.getAllNotesList;
import static data.KeyboardButtons.getMainMenu;

public class NotesCommand extends CommandService {

    public NotesCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        ReplyKeyboardMarkup keyboard = getMainMenu();
        sendAnswer(
                absSender,
                chat.getId(),
                this.getCommandIdentifier(),
                user,
                getAllNotesList(),
                keyboard
        );
    }
}
