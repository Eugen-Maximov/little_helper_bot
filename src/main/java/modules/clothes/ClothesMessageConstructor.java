package modules.clothes;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class ClothesMessageConstructor {

    /*
    //TODO идеальное сообщение   
    1 part
    По ощущениям сегодня утром будет около MORNING, днем будет где-то DAY, ночью же примерно NIGHT (среднее значение)
    2 part
    Лучше одеть CLOTHES_DAILY днем, а ночью CLOTHES_NIGHT. if (MORNING & NIGHT = холодно) то рекомендую взять куртку
    3 part
    if (rain) Кстати DAY_PART-S (склонение!) ожидается RAIN - не забудь зонтик!
    4 part
    if () что-то
    5 part
    if () что-то (мб заметки)
     */

    private final StringBuilder message = new StringBuilder();
    private final Response response;

    public ClothesMessageConstructor(Response response) {
        this.response = response;
    }

    public String createClothesMessage() {
        message.append("Средняя температура за день: ");
        message.append(getAverageDailyTemp());
        return message.toString();
    }

    private String getAverageDailyTemp() {
        double temp = 0;
        int parts = 6;
        for (int i = 0; i < parts; i++) {
            temp += Double.parseDouble(response.jsonPath().getString("list[" + i + "].dt_txt"));
        }
        return String.valueOf(temp / parts);
    }
}
