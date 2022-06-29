import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MainApplication {

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot());
            startDailyMessaging();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    private static void startDailyMessaging() throws SchedulerException {
        /* Instantiate the job that will call the bot function */
        JobDetail jobSendAd = JobBuilder.newJob(ScheduledWeatherForecast.class)
                .withIdentity("sendWeather")
                .build();
        /* Define a trigger for the call */
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("everyMorningAt10")
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(11, 0))
                .build();
        /* Create a scheduler to manage triggers */
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.getContext().put("bot", new Bot());
        scheduler.start();
        scheduler.scheduleJob(jobSendAd, trigger);
    }
}
