package data;

public enum KeyboardButtons {

    //main menu
    HELP_BUTTON ("/help"),
    WEATHER_BUTTON ("/weather");

    final String buttonName;

    KeyboardButtons(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}