package modules.weather;

import data.Messages;
import data.bot_users.BotUser;
import helpers.Request;
import io.restassured.response.Response;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

import static data.Environments.API_TOKEN;

public class GetWeather {

    private final String URL = "https://api.openweathermap.org/data/2.5/forecast";
    private final String apiToken = System.getenv(API_TOKEN.getEnvName());
    private final Map<String, String> query = new HashMap<>();

    public String getWeather(BotUser user) {
        return requestWeather(user);
    }

    private void setQuery(BotUser user) {
        query.put("appId", apiToken);
        query.put("lat", String.valueOf(user.getUserLat()));
        query.put("lon", String.valueOf(user.getUserLon()));
        query.put("units", "metric");
        query.put("lang", user.getUserLocale());
    }

    private String requestWeather(BotUser user) {
        setQuery(user);
        Response response = new Request(URL, query).sendRequest();
        if (response.getStatusCode() != 200) {
            return Messages.incorrectRequest;
        } else {
            return new WeatherParser(response).parseWeather();
        }
    }

}
