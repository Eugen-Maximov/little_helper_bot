package commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import static api.NotionController.createNote;
import static api.NotionController.getAllNotesList;
import static data.KeyboardButtons.getMainMenu;

public class NoCommand {

    public SendMessage noCommandExecute(Long chatId, User user, Message message) {
        SendMessage newMessage = new SendMessage();
        newMessage.setText(getMessageText(user, message));
        newMessage.setReplyMarkup(getMainMenu());
        return newMessage;
    }

    private String getMessageText(User user, Message message) {
        switch (message.getText()) {
            case "Notes":
                return getAllNotesList();
            default:
                return createNote(message.getText());
        }
    }

}
