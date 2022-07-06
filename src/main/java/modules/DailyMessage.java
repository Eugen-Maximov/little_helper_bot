package modules;

import main.bot_users.BotUser;
import main.Bot;
import modules.clothes.ClothesMessageConstructor;
import modules.weather.GetWeather;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Map;

import static main.bot_users.UsersContainer.getUsers;

public class DailyMessage implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        Bot bot = new Bot().getBot();
        for (Map.Entry<User, BotUser> entry : getUsers().entrySet()) {
            BotUser user = entry.getValue();
            if (user.isHaveLocation()) {
                bot.setAnswer(
                        user.getUserChatID(),
                        user,
                        new GetWeather().getWeatherForMessage(user)
                );
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}