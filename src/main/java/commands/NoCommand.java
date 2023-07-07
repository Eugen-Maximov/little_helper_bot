package commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import static data.NotesController.createNote;
import static data.NotesController.getNotes;
import static data.KeyboardButtons.getMenu;

public class NoCommand {

    public SendMessage noCommandExecute(Long chatId, User user, Message message) {
        SendMessage newMessage = new SendMessage();
        newMessage.setText(getMessageText(user, message));
        newMessage.setReplyMarkup(getMenu());
        return newMessage;
    }

    private String getMessageText(User user, Message message) {
        switch (message.getText()) {
            case "Notes":
                return getNotes(user);
            default:
                return createNote(user, message.getText());
        }
    }

}
