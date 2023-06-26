package commands;

import main.CommandService;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static data.KeyboardButtons.getMenu;


public class StartCommand extends CommandService {

    public StartCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String message = "Привет, я Notepad Bot!\nПозволяю быстро записывать информацию. Просто напиши что-нибудь в чат";
        ReplyKeyboardMarkup keyboard = getMenu();
        sendAnswer(
                absSender,
                chat.getId(),
                this.getCommandIdentifier(),
                user,
                message,
                keyboard
        );
    }
}
