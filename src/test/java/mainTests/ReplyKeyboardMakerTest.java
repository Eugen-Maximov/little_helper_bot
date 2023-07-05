package mainTests;

import main.ReplyKeyboardMaker;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReplyKeyboardMakerTest {

    private ReplyKeyboardMarkup testKeyboard;

    @Test
    public void testCreateEmptyKeyboard() {
        try {
            testKeyboard = new ReplyKeyboardMaker().createKeyboard(null);
            throw new AssertionError("Expecting NPM, but it isn't exist");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testCreateOneElementKeyboard() {
        List<KeyboardButton> buttons = createTestButtonsList(1);
        testKeyboard = new ReplyKeyboardMaker().createKeyboard(buttons);
        assertThat(
                "Keyboard rows are not equal to 1",
                testKeyboard.getKeyboard().size(),
                is(1)
        );
        assertThat(
                testKeyboard.getKeyboard().get(0).get(0),
                equalTo(buttons.get(0))
        );
    }

    @Test
    public void testCreateOneRowKeyboard() {
        int count = 3;
        List<KeyboardButton> buttons = createTestButtonsList(count);
        testKeyboard = new ReplyKeyboardMaker().createKeyboard(buttons);
        assertThat(
                "Keyboard rows are not equal to 1",
                testKeyboard.getKeyboard().size(),
                is(1)
        );
        assertThat(
                "Keyboard buttons are not equal to " + count,
                testKeyboard.getKeyboard().get(0).size(),
                equalTo(count)
        );
    }

    @Test
    public void testCreateTwoIncompleteRowsKeyboard() {
        List<KeyboardButton> buttons = createTestButtonsList(4);
        testKeyboard = new ReplyKeyboardMaker().createKeyboard(buttons);
        assertThat(
                "Keyboard rows are not equal to 2",
                testKeyboard.getKeyboard().size(),
                is(2)
        );
        assertThat(
                "Keyboard first row isn't have 3 elements",
                testKeyboard.getKeyboard().get(0).size(),
                equalTo(3)
        );
        assertThat(
                "Keyboard second row isn't have 1 element",
                testKeyboard.getKeyboard().get(1).size(),
                equalTo(1)
        );
    }

    @Test
    public void testCreateMaxCompleteRowsKeyboard() {
        List<KeyboardButton> buttons = createTestButtonsList(9);
        testKeyboard = new ReplyKeyboardMaker().createKeyboard(buttons);
        assertThat(
                "Keyboard rows are not equal to 3",
                testKeyboard.getKeyboard().size(),
                is(3)
        );
        assertThat(
                "Keyboard first row isn't full",
                testKeyboard.getKeyboard().get(0).size(),
                equalTo(3)
        );
        assertThat(
                "Keyboard second row isn't full",
                testKeyboard.getKeyboard().get(1).size(),
                equalTo(3)
        );
        assertThat(
                "Keyboard third row isn't full",
                testKeyboard.getKeyboard().get(2).size(),
                equalTo(3)
        );
    }

    @Test
    public void testCreateMoreMaxSizeKeyboard() {
        List<KeyboardButton> buttons = createTestButtonsList(15);
        testKeyboard = new ReplyKeyboardMaker().createKeyboard(buttons);
        assertThat(
                "keyboard rows are not equal to max keyboard size",
                testKeyboard.getKeyboard().size(),
                equalTo(3)
        );
        assertThat(
                "Keyboard third row isn't full",
                testKeyboard.getKeyboard().get(2).size(),
                equalTo(3)
        );
    }

    private List<KeyboardButton> createTestButtonsList(int countOfButtons) {
        List<KeyboardButton> buttons = new ArrayList<>();
        for (int i = 0; i < countOfButtons; i++) {
            buttons.add(
                    new KeyboardButton("Test button" + i)
            );
        }
        return buttons;
    }
}
