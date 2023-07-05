package data;

import org.telegram.telegrambots.meta.api.objects.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static data.Texts.NO_NOTES;

public class Database {

    private static final Map<User, List<String>> DB = new HashMap<>();
    private static final String separator = ". ";

    private static void addNewUser(User user) {
        DB.put(user, new ArrayList<>());
    }

    private static boolean ifHasUser(User user) {
        return DB.containsKey(user);
    }

    public static void createNote(User user, String note) {
        if (!ifHasUser(user)) addNewUser(user);
        DB.get(user).add(note);
    }

    public static String getNotes(User user) {
        if (!ifHasUser(user)) {
            addNewUser(user);
            return NO_NOTES;
        }
        if (DB.get(user).size() == 0) return NO_NOTES;
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String s : DB.get(user)) {
            builder
                    .append(i)
                    .append(separator)
                    .append(s)
                    .append("\n\n");
            i++;
        }
        return builder.toString();
    }

    public static void clearNotes(User user) {
        if (ifHasUser(user)) {
            DB.get(user).clear();
        }
    }
}
