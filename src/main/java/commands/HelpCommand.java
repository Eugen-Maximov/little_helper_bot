package commands;

import main.Bot;
import main.CommandService;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static data.Texts.HELP_MESSAGE;


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
                createMessage()
        );
    }

    private String createMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (IBotCommand command : new Bot().getRegisteredCommands()) {
            stringBuilder.append("/");
            stringBuilder.append(command.getCommandIdentifier());
            stringBuilder.append(" - ");
            stringBuilder.append(command.getDescription());
            stringBuilder.append("\n");
        }
        return HELP_MESSAGE.replace(
                "%commands%", stringBuilder.toString()
        );
    }
}
