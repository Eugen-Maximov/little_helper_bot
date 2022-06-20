package commands;

public enum AllCommands {

    START ("start"),
    HELLO ("hello"),
    WEATHER ("weather");

    private String command;

    AllCommands(String command) {
        this.command = command;
    }
}
