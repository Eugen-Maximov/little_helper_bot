package helpers;

import data.InputStatus;
import data.Messages;
import main.bot_users.BotUser;
import org.telegram.telegrambots.meta.api.objects.Message;

import static data.InputStatus.EMPTY;
import static data.InputStatus.UNREGISTER;

public class InputHelper {

    public static void openInput(BotUser user, InputStatus status) {
        user.setInputStatus(status);
    }

    public static void closeInput(BotUser user) {
        user.setInputStatus(EMPTY);
    }

    public static InputStatus getActualStatus(BotUser user) { //TODO make private after end of debug
        if (user == null) return UNREGISTER;
        return user.getInputStatus();
    }

    public static String input(Message message, BotUser user) {
        InputStatus status = getActualStatus(user);
        switch (status) {
            case CREATE_LOCATION:
                return new Location().inputLocation(message, user);
            case NOTE:
                return "debug field";
            case EMPTY:
                return Messages.cantUnderstandMessage;
            case UNREGISTER:
                return Messages.Input.unregisterMessage;
            default:
                return Messages.Input.undefinedInput;
        }
    }
}
