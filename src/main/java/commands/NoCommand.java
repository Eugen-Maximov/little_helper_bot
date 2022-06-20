package commands;

import data.InputStatus;
import data.Messages;

import java.util.HashMap;
import java.util.Map;

import static data.InputStatus.EMPTY;
import static data.Location.setLocation;

public class NoCommand {

    private static Map<Long, InputStatus> inputStatus = new HashMap<>();

    public String nonCommandExecute(Long chatId, Long userId, String text) {
        if (isInput(userId)) {
            return inputData(inputStatus.get(userId), text, userId);
        } else {
            return Messages.cantUnderstandMessage;
        }
    }

    public static void enableInput(InputStatus inputStatus, Long userId) {
        NoCommand.inputStatus.put(userId, inputStatus);
    }

    private boolean isInput(Long userId) {
        return inputStatus.get(userId) != EMPTY;
    }

    private void closeInput(Long userId) {
        inputStatus.put(userId, EMPTY);
    }

    private String inputData(InputStatus status, String text, Long userId) {
        switch (status) {
            case LOCATION:
                String result = setLocation(text, userId);
                closeInput(userId);
                return result;
            case NOTE:
                return "debug field";
            case EMPTY:
                return "Ввод запрещен";
            default:
                return "Простите, я не понимаю вас. Возможно.";
        }
    }
}
