package data;

public enum Environments {

    TELEGRAM_TOKEN("BOT_TOKEN"),
    API_TOKEN("API_TOKEN"),
    DB_URI("DB_URI");

    private final String envName;

    Environments(String envName) {
        this.envName = envName;
    }

    public String getName() {
        return envName;
    }
}
