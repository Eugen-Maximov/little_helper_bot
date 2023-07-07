package helpers;

import helpers.db.DataBaseOperations;
import helpers.db.NoteDbObject;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.ArrayList;
import java.util.List;

import static data.Texts.CANNOT_DELETE_MESSAGE;
import static data.Texts.CLEAR_MESSAGE;
import static data.Texts.INDENT;
import static data.Texts.NOTE_ADDED;
import static data.Texts.NO_NOTES;
import static data.Texts.NO_NOTES_TO_DELETE;
import static data.Texts.SEPARATOR;
import static data.Texts.SUCCESSFUL_REMOVAL;

public class NotesController extends DataBaseOperations {

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

    public static List<String> getNotesAsListToDeleteMethod(User user) {
        List<String> list = new ArrayList<>();
        for (NoteDbObject object : selectUserNotesByUserId(user)) {
            list.add(object.getUserNote());
        }
        return list;
    }

    public static String clearAllUserNotes(User user) {
        clearNotes(user);
        return CLEAR_MESSAGE;
    }

    public static String deleteUserNote(User user, String[] noteToDeleteParam) {
        StringBuilder sb = new StringBuilder();
        if (noteToDeleteParam.length != 1) {
            sb.append(CANNOT_DELETE_MESSAGE);
        } else {
            int noteNum = Integer.parseInt(noteToDeleteParam[0]);
            List<String> listToDelete = getNotesAsListToDeleteMethod(user);
            try {
                deleteNote(user, listToDelete.get(noteNum));
                sb.append(SUCCESSFUL_REMOVAL);
            } catch (IndexOutOfBoundsException e) {
                sb.append(NO_NOTES_TO_DELETE);
                sb.append(noteNum);
            }
        }
        return sb.toString();
    }
}
