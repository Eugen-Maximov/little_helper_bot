package data;

public enum Environments {

    TELEGRAM_TOKEN("BOT_TOKEN"),
    API_TOKEN("API_TOKEN");

    private String envName;

    Environments(String envName) {
        this.envName = envName;
    }

    public String getEnvName() {
        return envName;
    }
}
