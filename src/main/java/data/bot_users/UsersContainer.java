package data.bot_users;

import org.telegram.telegrambots.meta.api.objects.User;

import java.util.HashMap;

public class UsersContainer {

    private static final HashMap<User, BotUser> users = new HashMap<>();

    public static void addUser(User user, BotUser botUser) {
        if (!isHasUser(user)) {
            users.put(user, botUser);
        } else {
            changeUser(user, botUser);
        }
    }

    public static HashMap<User, BotUser> getUsers() {
        return users;
    }

    public static void deleteUser(User user) {
        users.remove(user);
    }

    public static void changeUser(User user, BotUser botUser) {
        users.replace(user, botUser);
    }

    public static boolean isHasUser(User user) {
        return users.containsKey(user);
    }

    public static BotUser getUser(User user) {
        return users.get(user);
    }
}
