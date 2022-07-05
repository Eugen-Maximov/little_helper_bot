package data;

public enum Environments {

    TELEGRAM_TOKEN("BOT_TOKEN"),
    API_TOKEN("API_TOKEN"),
    DB_URI("DB_URI"),
    DB_USER("DB_USER"),
    DB_PASS("DB_PASS");

    private String envName;

    Environments(String envName) {
        this.envName = envName;
    }

    public String getEnvName() {
        return envName;
    }
}
