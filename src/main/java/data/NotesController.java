package data;

import helpers.db.NoteDbObject;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

import static data.Texts.CLEAR_MESSAGE;
import static data.Texts.INDENT;
import static data.Texts.NOTE_ADDED;
import static data.Texts.NO_NOTES;
import static data.Texts.SEPARATOR;
import static helpers.db.DataBaseOperations.deleteNotes;
import static helpers.db.DataBaseOperations.insertNewNote;
import static helpers.db.DataBaseOperations.selectUserNotesByUserId;

public class NotesController {

    public static String createNote(User user, String note) {
        insertNewNote(user, note);
        return NOTE_ADDED;
    }

    public static String getNotes(User user) {
        List<NoteDbObject> list = selectUserNotesByUserId(user);
        if (list.isEmpty()) return NO_NOTES;
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (NoteDbObject object : list) {
            builder
                    .append(count)
                    .append(SEPARATOR)
                    .append(object.getUserNote())
                    .append(INDENT);
            count++;
        }
        return builder.toString();
    }

    public static String clearAllUserNotes(User user) {
        deleteNotes(user);
        return CLEAR_MESSAGE;
    }

    public static String deleteUserNote(User user, String noteToDelete) {
        return null;
    }
}
