package helpers;

import data.Messages;
import main.bot_users.BotUser;
import io.restassured.response.Response;
import modules.weather.GetWeather;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static data.Environments.API_TOKEN;
import static data.InputStatus.CREATE_LOCATION;
import static helpers.InputHelper.closeInput;
import static helpers.InputHelper.openInput;

public class Location {

    private final String URL = "http://api.openweathermap.org/geo/1.0/reverse";
    private final String geoToken = System.getenv(API_TOKEN.getName());
    private final Map<String, String> query = new HashMap<>();


    public String inputLocation(Message message, BotUser user) {
        String result;
        closeInput(user);
        user.setUserChatID(message.getChatId());
        if (message.hasLocation()) {
            setQuery(
                    message.getLocation().getLatitude(),
                    message.getLocation().getLongitude());
            result = requestLocation(user);
            user.setUserLocation(
                    message.getLocation().getLatitude(),
                    message.getLocation().getLongitude()
            );
            result += Messages.divider;
            result += new GetWeather().getWeatherForMessage(user);
        } else {
            result = "Немного не похоже на геопозицию." + Messages.Input.tryAgainMessage;
            openInput(user, CREATE_LOCATION);
        }
        return result;
    }

    private void setQuery(Double lat, Double lon) {
        query.put("appId", geoToken);
        query.put("lat", String.valueOf(lat));
        query.put("lon", String.valueOf(lon));
    }

    private String requestLocation(BotUser user) {
        Response response = new Request(URL, query).sendRequest();
        if (response.getStatusCode() != 200) {
            //openInput(user, CREATE_LOCATION); //TODO maybe its must to be?
            return Messages.incorrectRequest;
        } else {
            user.setUserGeo(
                    getLatLon(),
                    response.getBody().jsonPath().getString("local_names." + user.getUserLocale()), //TODO may been error with empty land field
                    response.getBody().jsonPath().getString("country")
            );
            return Messages.Locations.correctLocation +
                    "\n1. \uD83C\uDF06Город: " + user.getUserCity() +
                    "\n2. \uD83D\uDDFAРегион: " + user.getUserRegion() +
                    "\n3. \uD83C\uDF10Координаты: " + Arrays.toString(user.getUserLocation());
        }
    }

    private Double[] getLatLon() {
        Double[] latLon = new Double[2];
        latLon[0] = Double.valueOf(query.get("lat"));
        latLon[1] = Double.valueOf(query.get("lon"));
        return latLon;
    }
}
