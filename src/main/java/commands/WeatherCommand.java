package commands;

import data.Messages;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static commands.NoCommand.enableInput;
import static data.InputStatus.LOCATION;
import static data.Location.getLocation;
import static data.Location.hasLocation;

public class WeatherCommand extends CommandService {


    public WeatherCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        sendMessage(absSender, user, chat, strings);
    }

    private void sendMessage(AbsSender absSender, User user, Chat chat, String[] strings)  {
        if (!hasLocation(user.getId())) {
            Long userId = user.getId();
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userId,
                    Messages.Weather.enterCityMessage);
            enableInput(LOCATION, userId);
        } else {
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user.getId(),
                    Messages.Weather.cityAlreadyExistMessage + getLocation(user.getId()));
            //TODO: send request
        }
    }
}
