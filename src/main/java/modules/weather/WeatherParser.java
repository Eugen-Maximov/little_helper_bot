package modules.weather;


import data.Messages;
import io.restassured.response.Response;

import static helpers.DateTimeConverter.convertTime;
import static modules.weather.WeatherIcons.getIcon;

public class WeatherParser {

    private final Response response;
    private final StringBuilder builder = new StringBuilder();


    public WeatherParser(Response response) {
        this.response = response;
    }

    public String parseWeatherForMessage() {
        builder.append(Messages.Weather.startWeatherActualMessage);
        builder.append(parseTime());
        builder.append(parseTemperature());
        builder.append(parseWeatherStatus());
        return builder.toString();
    }

    private String parseTime() {
        String startTime = convertTime(response.jsonPath().getString("list[0].dt_txt"));
        String endTime = convertTime(response.jsonPath().getString("list[2].dt_txt"));
        return "\uD83D\uDD53" + startTime +
                "-" + endTime + "\n";
    }

    private String parseTemperature() {
        return "\uD83C\uDF21Температура: " +
                response.jsonPath().getString("list[0].main.temp") +
                " -> " + response.jsonPath().getString("list[1].main.temp") +
                "\n" +
                "\uD83C\uDF21Ощущается как: " +
                response.jsonPath().getString("list[0].main.feels_like") +
                " -> " + response.jsonPath().getString("list[1].main.feels_like") +
                "\n";
    }

    private String parseWeatherStatus() {
        return getIcon(response.jsonPath().getInt("list[0].weather[0].id")) +
                response.jsonPath().getString("list[0].weather[0].description") + " -> " +
                getIcon(response.jsonPath().getInt("list[1].weather[0].id")) +
                response.jsonPath().getString("list[1].weather[0].description");
    }

}
