package helpers;

import org.telegram.telegrambots.meta.api.objects.User;

import static data.Environments.ADMIN;
import static data.Environments.getEnvValue;

public class AllowedUsersHelper {

    private static final Long ADMIN_TOKEN = Long.valueOf(getEnvValue(ADMIN));

    public static boolean ifAdmin(User user) {
        return user.getId().equals(ADMIN_TOKEN);
    }
}
