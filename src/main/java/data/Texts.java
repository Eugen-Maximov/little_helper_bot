package data;

import helpers.VersionUtil;


public class Texts {

    private static final String APPLICATION_VERSION = VersionUtil.getApplicationVersion();

    public static final String START_MESSAGE = "Главное меню приветствует тебя! \n" +
            "Пока что я нахожусь в разработке. \nПожалуйста не ругайте меня\uD83D\uDE22 \n\n\n" +
            "Моя версия: " + APPLICATION_VERSION;
    public static final String HELP_MESSAGE = "Привет! Ты здесь за помощью? \n" +
            "Сейчас я расскажу что я умею: \n" +
            "\n\n\nВерсия бота: " + APPLICATION_VERSION;
    public static final String CLEAR_MESSAGE = "Все заметки удалены.";
    public static final String NO_NOTES = "Кажется заметок не существует. ";

    public static final String DIVIDER = "\n\n-----------------------\n\n";
}
