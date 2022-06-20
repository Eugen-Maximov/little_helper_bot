package data;

import java.util.HashMap;
import java.util.Map;

import static functions.GetWeather.canFindWeather;

public class Location {

    private static Map<Long, String> locationNames = new HashMap<>();

//    static {
//        locationNames.put(187011039L, "Moscow");
//    }

    public static boolean hasLocation(Long userId) {
        return locationNames.get(userId) != null;
    }

    public static String setLocation(String location, Long userId) {
        locationNames.put(userId, location);
        if (canFindWeather(userId)) {
            return Messages.Locations.correctLocation + location;
        } else {
            deleteLocation(userId);
            return Messages.Locations.incorrectLocation;
        }
    }

    public static String getLocation(Long user) {
        return locationNames.get(user);
    }

    public static Map<Long, String> getAllLocations() {
        return locationNames;
    }

    public static void deleteLocation(Long userId) {
        locationNames.put(userId, null);
    }
}
