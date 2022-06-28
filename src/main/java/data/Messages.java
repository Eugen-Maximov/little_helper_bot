package data;

import helpers.VersionUtil;


public class Messages {

    private static final String version = VersionUtil.getApplicationVersion();

    public static String startMessage = "Привет! Я Декс - ваш персональный помощник. \n" +
            "Полный список того, что я умею, а также если Вам нужна помощь, нажмите /help\n\n" +
            "Пока что я нахожусь в разработке. \nПожалуйста не ругайте меня\uD83D\uDE22 \n\n\n" +
            "Моя версия: " + version;
    public static String helpMessage = "Привет! Ты здесь за помощью? \n" +
            "Сейчас я расскажу что я умею: \n" +
            "1️⃣ /weather - можно получить информацию о погоде" +
            "\n\n\nВерсия бота: " + version;
    public static String cantUnderstandMessage = "Простите, я не понимаю вас. Возможно, Вам поможет /help";
    public static String incorrectRequest = "\uD83D\uDE31Кажется что-то пошло не так: " +
            "\nНе получается получить ответ от сервера. " +
            "\nПопробуйте поменять параметры или попробуйте чуть попозже.";
    public static String divider = "\n\n-----------------------\n\n";

    public static class Weather {
        public static String enterCityMessage = "Отправьте свою геопозицию через Телеграм";
        public static String cityAlreadyExistMessage = "Город уже есть. Ваш город: ";

        public static String startWeatherActualMessage = "Погода сейчас: \n";
    }

    public static Locations locationsMessages;
    public static class Locations {
        public static String incorrectLocation = "Не удалось получить погоду по выбранной локации. Проверьте указанные данные или попробуйте позже.";
        public static String correctLocation = "Отлично, теперь у вас есть местоположение! \nВы ввели: ";
    }

    public static Settings settingsMessages;
    public static class Settings {
        public static String startSettingsMessage = "Добро пожаловать в настройки. ";
    }

    public static class Input {
        public static String undefinedInput = "Не могу понять, куда записать ваши данные\uD83E\uDD14" +
                "\nМожет попробуем снова?";
        public static String tryAgainMessage = "Пожалуйста, попробуйте снова!";
        public static String unregisterMessage = "Кажется я вас не знаю или забыл\uD83D\uDC40 \nКликни на /start, познакомимся!";
    }
}
