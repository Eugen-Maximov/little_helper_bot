package main;

import helpers.LogHelper;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.WARNING;

public class ReplyKeyboardMaker {

    static Logger LOGGER = LogHelper.LOGGER;

    private final List<KeyboardRow> keyboard = new ArrayList<>();
    private final int MAX_KEYBOARD_SIZE = 9;

    public ReplyKeyboardMarkup createKeyboard(List<KeyboardButton> buttons) {
        if (buttons.size() > MAX_KEYBOARD_SIZE) {
            LOGGER.log(WARNING, "Keyboard cannot be more than 9 elements");
            buttons = cutListToMaxSize(buttons);
        }
        createKeyboardButtons(buttons);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;

    }

    //TODO maybe i can optimise it more?
    private void createKeyboardButtons(List<KeyboardButton> buttons) {
        int count = 0;
        int rowNum = 0;
        keyboard.add(new KeyboardRow());
        for (int i = 0; i < buttons.size(); i++) {
            keyboard.get(rowNum).add(buttons.get(i));
            ++count;
            if (count == 3 && buttons.get(i) != buttons.get(buttons.size() - 1)) {
                count = 0;
                rowNum++;
                keyboard.add(new KeyboardRow());
            }
        }
    }

    private List<KeyboardButton> cutListToMaxSize(List<KeyboardButton> originalList) {
        List<KeyboardButton> newList = new ArrayList<>();
        for (int i = 0; i < MAX_KEYBOARD_SIZE; i++) {
            newList.add(originalList.get(i));
        }
        return newList;
    }
}
