package data;

import main.ReplyKeyboardMaker;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.Arrays;

public enum KeyboardButtons {

    SHOW_NOTE(new KeyboardButton("Notes")),
    DELETE_NOTE(new KeyboardButton("Delete"));

    private final KeyboardButton button;

    KeyboardButtons(KeyboardButton button) {
        this.button = button;
    }

    public KeyboardButton getButton() {
        return button;
    }

    public String getButtonText() {
        return button.getText();
    }

    public static ReplyKeyboardMarkup getMainMenu() {
        ReplyKeyboardMaker keyboardMaker = new ReplyKeyboardMaker();
        return keyboardMaker.createKeyboard(
                Arrays.asList(
                        SHOW_NOTE.getButton())
        );
    }


}
