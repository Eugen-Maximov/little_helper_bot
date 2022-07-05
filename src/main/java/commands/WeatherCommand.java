package commands;

import data.Messages;
import main.bot_users.BotUser;
import main.CommandService;
import modules.weather.GetWeather;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Arrays;

import static data.InputStatus.CREATE_LOCATION;
import static main.bot_users.UsersContainer.getUser;
import static helpers.InputHelper.openInput;

public class WeatherCommand extends CommandService {


    public WeatherCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User tgUser, Chat chat, String[] strings) {
        BotUser user = getUser(tgUser);
        createMessage(absSender, user, chat, strings);
    }

    private void createMessage(AbsSender absSender, BotUser user, Chat chat, String[] strings) {
        if (!user.isHaveLocation()) {
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user,
                    Messages.Weather.enterCityMessage);
            openInput(user, CREATE_LOCATION);
        } else if (user.isHaveLocation()) {
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user,
                    new GetWeather().getWeather(user));
        } else {
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user,
                    Messages.Weather.cityAlreadyExistMessage + Arrays.toString(user.getUserLocation()));
        }
    }
}
