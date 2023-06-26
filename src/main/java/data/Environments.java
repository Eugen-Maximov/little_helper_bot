package data;

public enum Environments {

    TELEGRAM_TOKEN("BOT_TOKEN"),
    API_TOKEN("API_TOKEN"),
    ADMIN("ADMIN");

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
