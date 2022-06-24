package helpers;

import data.Messages;
import data.bot_users.BotUser;
import io.restassured.response.Response;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static data.InputStatus.CREATE_LOCATION;
import static helpers.InputHelper.closeInput;
import static helpers.InputHelper.openInput;

public class Location {

    private final String geoUrl = "http://api.openweathermap.org/geo/1.0/reverse";
    private final String geoToken = System.getenv("GEO_TOKEN");
    private final Map<String, String> query = new HashMap<>();
    private Response response;
    private Double[] latLon;


    public String inputLocation(Message message, BotUser user) {
        String result;
        closeInput(user);
        if (message.hasLocation()) {
            setQuery(message.getLocation().getLatitude(), message.getLocation().getLongitude());
            result = requestLocation(user);
//            user.setUserLocation(
//                    message.getLocation().getLatitude(),
//                    message.getLocation().getLongitude()
//            );
            //TODO check weather + region and save them + reopen input if false
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
        latLon[0] = lat;
        latLon[1] = lon;
    }

    //TODO
    private String requestLocation(BotUser user) {
//        response = new Request(geoUrl, query).sendRequest();
//        if (response.getBody().jsonPath().getInt("cod") != 200 || response.getBody().jsonPath().get("cod") != null)
//            return Messages.incorrectRequest;
//        user.setUserGeo(latLon, response.getBody().jsonPath().getString("local_names." + user.getUserLocale()), response.getBody().jsonPath().getString("country"));
        return Messages.Locations.correctLocation + "\n1." + user.getUserCity() + "\n2." + user.getUserRegion() + "\n3." + Arrays.toString(user.getUserLocation());
    }
}
