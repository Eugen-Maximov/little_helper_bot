package data;

public enum Environments {

    TELEGRAM_TOKEN("BOT_TOKEN"),
    ADMIN("ADMIN"),
    DB_URL("DB_URL");

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
