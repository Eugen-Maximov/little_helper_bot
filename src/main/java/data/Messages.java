package data;

public class Messages {

    public static String startMessage = "Привет! Я Декс - ваш персональный помощник. Полный список того, что я умею, а также если Вам нужна помощь, нажмите /help";
    public static String helpMessage = "Привет! Ты здесь за помощью? \n" +
            "Сейчас я расскажу что я умею: \n" +
            "1️⃣ /weather - можно получить информацию о погоде";
    public static String cantUnderstandMessage = "Простите, я не понимаю вас. Возможно, Вам поможет /help";

    public static Weather weatherMessages;
    public static class Weather {
        public static String enterCityMessage = "Введите название города";
        public static String cityAlreadyExistMessage = "Город уже есть. Ваш город: ";
    }

    public static Locations locationsMessages;

    public static class Locations {
        public static String incorrectLocation = "Не удалось получить погоду по выбранной локации. Проверьте указанные данные или попробуйте позже.";
        public static String correctLocation = "Локация установлена успешно! \nВы ввели: ";
    }
}
