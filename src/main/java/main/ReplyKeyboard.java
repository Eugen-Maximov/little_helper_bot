package main;

import data.KeyboardButtons;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyboard {

    private List<KeyboardRow> keyboard;
    private int keyboardSize;

    public ReplyKeyboardMarkup createKeyboard(List<KeyboardButtons> buttons) {
        setKeyboardSize(buttons);
        keyboard = createKeyboardsRows(keyboardSize);
        createKeyboardButtons(buttons);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }

    private List<KeyboardRow> createKeyboardsRows(int numOfRows) {
        List<KeyboardRow> rowList = new ArrayList<>();
        for (int i = 0; i < numOfRows; i++) {
            rowList.add(new KeyboardRow());
        }
        return rowList;
    }

    private void createKeyboardButtons(List<KeyboardButtons> buttons) {
        int i = 1;
        int index = 0;
        for (KeyboardButtons btn : buttons) {
            keyboard.get(i).add(new KeyboardButton(btn.getButtonName()));
            ++index;
            if (buttons.indexOf(btn) == index) {
                i = 2;
                index = 0;
            }
        }
    }

    private int setKeyboardSize(List<KeyboardButtons> buttons) {
        if (buttons.size() < 3) return this.keyboardSize = buttons.size();
        int size = buttons.size() / 3;
        if (buttons.size() % 3 != 0) {
            size += 1;
        }
        return this.keyboardSize = size;
    }
}
