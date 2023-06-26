package main;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyboardMaker {

    private final List<KeyboardRow> keyboard = new ArrayList<>();

    public ReplyKeyboardMarkup createKeyboard(List<KeyboardButton> buttons) {
        createKeyboardButtons(buttons);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }

    private void createKeyboardButtons(List<KeyboardButton> buttons) {
        int i = 0;
        keyboard.add(new KeyboardRow());
        for (KeyboardButton btn : buttons) {
            keyboard.get(i).add(btn);
            if (buttons.indexOf(btn) % 3 == 0 && buttons.indexOf(btn) != 0) {
                keyboard.add(new KeyboardRow());
                ++i;
            }
        }
    }
}
