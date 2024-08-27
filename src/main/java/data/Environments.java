package data;

public enum Environments {

    TELEGRAM_TOKEN("BOT_TOKEN"),
    ADMIN("ADMIN"),
    NOTION_KEY("NOTION_KEY");

    private final String envName;

    Environments(String envName) {
        this.envName = envName;
    }

    public String getName() {
        return envName;
    }

    public static String getEnvValue(Environments envName) {
        return System.getenv(envName.getName());
    }
}
