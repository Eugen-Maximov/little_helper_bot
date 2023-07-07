package data;

import helpers.VersionUtil;


public class Texts {

    private static final String APPLICATION_VERSION = VersionUtil.getApplicationVersion();

    public static final String START_MESSAGE = "Привет, я Notepad Bot!\n" +
            "Позволяю быстро записывать информацию. Просто напиши что-нибудь в чат\n" +
            "Пока что я нахожусь в разработке. \nПожалуйста не ругайте меня\uD83D\uDE22 \n\n\n" +
            "Моя версия: " + APPLICATION_VERSION;
    public static final String HELP_MESSAGE = "Привет! Ты здесь за помощью? \n" +
            "Сейчас я расскажу что я умею: \n" +
            "Напиши любое текстовое сообщение и я сохраню его как заметку. \n" +
            "Если написать Notes - я выведу список всех твоих заметок. \n\n" +
            "И еще вот список команд: \n" +
            "%commands%" +
            "\n\n\nВерсия бота: " + APPLICATION_VERSION;
    public static final String CLEAR_MESSAGE = "Все заметки удалены.";
    public static final String NO_NOTES = "Кажется заметок не существует. ";
    public static final String NOTE_ADDED = "Заметка добавлена";
    public static final String DIVIDER = "\n\n-----------------------\n\n";
    public static final String UNREGISTERED_USER_TEXT = "Bot is unavailable for you, please contact with @eu_v1";
    public static final String SEPARATOR = ". ";
    public static final String INDENT = "\n\n";
}
