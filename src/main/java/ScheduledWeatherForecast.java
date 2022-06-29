import data.bot_users.BotUser;
import modules.weather.GetWeather;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Map;

import static data.bot_users.UsersContainer.getUsers;

public class ScheduledWeatherForecast implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        Bot bot = new Bot().getBot();
        for (Map.Entry<User, BotUser> entry : getUsers().entrySet()) {
            BotUser user = entry.getValue();
            if (user.isHaveLocation()) {
                bot.sendScheduledMessage(
                        user,
                        new GetWeather().getWeather(user)
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