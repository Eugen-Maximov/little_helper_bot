package modules.weather;

import java.util.HashMap;

public class WeatherIcons {

    private static final HashMap<Integer, String> weatherIcons = new HashMap<>();

    static {
        //thunderstorm
        weatherIcons.put(200, "⛈");
        weatherIcons.put(201, "⛈");
        weatherIcons.put(202, "⛈");
        weatherIcons.put(210, "⛈");
        weatherIcons.put(211, "⛈");
        weatherIcons.put(212, "⛈");
        weatherIcons.put(221, "⛈");
        weatherIcons.put(230, "⛈");
        weatherIcons.put(231, "⛈");
        weatherIcons.put(232, "⛈");
        //drizzle
        weatherIcons.put(300, "\uD83C\uDF26");
        weatherIcons.put(301, "\uD83C\uDF26");
        weatherIcons.put(302, "\uD83C\uDF26");
        weatherIcons.put(310, "\uD83C\uDF26");
        weatherIcons.put(311, "\uD83C\uDF26");
        weatherIcons.put(312, "\uD83C\uDF26");
        weatherIcons.put(313, "\uD83C\uDF26");
        weatherIcons.put(314, "\uD83C\uDF26");
        weatherIcons.put(321, "\uD83C\uDF26");
        //rain
        weatherIcons.put(500, "\uD83C\uDF26");
        weatherIcons.put(501, "\uD83C\uDF26");
        weatherIcons.put(502, "\uD83C\uDF26");
        weatherIcons.put(503, "\uD83C\uDF26");
        weatherIcons.put(504, "\uD83C\uDF26");
        weatherIcons.put(511, "❄");
        weatherIcons.put(520, "\uD83C\uDF27");
        weatherIcons.put(521, "\uD83C\uDF27");
        weatherIcons.put(522, "\uD83C\uDF27");
        weatherIcons.put(531, "\uD83C\uDF27");
        //snow
        weatherIcons.put(600, "❄️");
        weatherIcons.put(601, "❄️");
        weatherIcons.put(602, "❄️");
        weatherIcons.put(611, "❄️");
        weatherIcons.put(612, "❄️");
        weatherIcons.put(613, "❄️");
        weatherIcons.put(615, "❄️");
        weatherIcons.put(616, "❄️");
        weatherIcons.put(620, "❄️");
        weatherIcons.put(621, "❄️");
        weatherIcons.put(622, "❄️");
        //Atmosphere
        weatherIcons.put(701, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(711, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(721, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(731, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(741, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(751, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(761, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(762, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(771, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        weatherIcons.put(781, "\uD83D\uDE36\u200D\uD83C\uDF2B️");
        //clear
        weatherIcons.put(800, "☀️");
        //clouds
        weatherIcons.put(801, "⛅");
        weatherIcons.put(802, "⛅");
        weatherIcons.put(803, "☁️");
        weatherIcons.put(804, "☁️");
    }

    public static String getIcon(Integer key) {
        return weatherIcons.get(key);
    }
}
