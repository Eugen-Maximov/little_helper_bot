package modules.weather;

import data.Messages;
import helpers.Request;
import io.restassured.response.Response;
import main.bot_users.BotUser;
import modules.clothes.ClothesMessageConstructor;

import java.util.HashMap;
import java.util.Map;

import static data.Environments.API_TOKEN;

public class GetWeather {

    private final String URL = "https://api.openweathermap.org/data/2.5/forecast";
    private final String apiToken = System.getenv(API_TOKEN.getName());
    private final Map<String, String> query = new HashMap<>();

    public String getWeatherForMessage(BotUser user) {
        return requestWeatherForMessage(user);
    }

    private void setQuery(BotUser user) {
        query.put("appId", apiToken);
        query.put("lat", String.valueOf(user.getUserLat()));
        query.put("lon", String.valueOf(user.getUserLon()));
        query.put("units", "metric");
        query.put("lang", user.getUserLocale());
    }

    private String requestWeatherForMessage(BotUser user) {
        setQuery(user);
        Response response = new Request(URL, query).sendRequest();
        if (response.getStatusCode() != 200) {
            return Messages.incorrectRequest;
        } else {
            return new WeatherParser(response).parseWeatherForMessage() +
                    new ClothesMessageConstructor(response).createClothesMessage();
        }
    }
}
