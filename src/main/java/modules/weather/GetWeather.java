package modules.weather;

import java.util.HashMap;
import java.util.Map;

public class GetWeather {

    private static final String weatherUrl = "http://api.weatherstack.com/current";
    private static final String apiToken = System.getenv("API_TOKEN");
    //private static final Map<Long, String> locations = Location.getAllLocations();
    private static final Map<String, String> requestParams = new HashMap<>();

    static {
        requestParams.put("access_key", apiToken);
        requestParams.put("language", "ru");
        requestParams.put("forecast_days", "1");
        requestParams.put("interval", "12");
        requestParams.put("units", "metrics");
    }


//    public static boolean canFindWeather(Long userId) {
//        requestParams.put("city", locations.get(userId));
//        Request request = new Request(weatherUrl, requestParams);
//        Response response = request.sendRequest();
//        return response.getBody().jsonPath().getBoolean("success");
//    }
}
