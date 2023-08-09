package data;

import helpers.VersionUtil;


public class Texts {

    private static final String APPLICATION_VERSION = VersionUtil.getApplicationVersion();

    public static final String START_MESSAGE = "Hi, I'm Notepad Bot!\n" +
            "I can save your text messages.\n" +
            "For now, I'm in development. \nPlease be patient\uD83D\uDE22 \n\n\n" +
            "My version: " + APPLICATION_VERSION;
    public static final String HELP_MESSAGE = "Hi! Do you need help? \n" +
            "That's what i can: \n" +
            "Write any text message and I'll save it. \n" +
            "If u write 'Notes' - I'll show you all saved notes. \n\n" +
            "And there is my commands list: \n" +
            "%commands%" +
            "\n\n\nBot version: " + APPLICATION_VERSION;
    public static final String CLEAR_MESSAGE = "All notes were successfully deleted.";
    public static final String NO_NOTES = "You don't have any saved note. ";
    public static final String NOTE_ADDED = "Note added";
    public static final String DIVIDER = "\n\n-----------------------\n\n";
    public static final String UNREGISTERED_USER_TEXT = "Bot is unavailable for you, please contact with @eu_v1";
    public static final String SEPARATOR = ". ";
    public static final String INDENT = "\n\n";
    public static final String CANNOT_DELETE_MESSAGE = "Incorrect format of the command. " +
            "Please send /delete + numbers of the notes with spaces to delete.\n" +
            "You can see saved notes /notes";
    public static final String CANNOT_FIND_NOTE_TO_DELETE = "Cannot find note to delete by note number: ";
    public static final String SUCCESSFUL_REMOVAL = "Note %noteNum% was successfully deleted";
}
