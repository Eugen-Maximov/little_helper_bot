package helpers.db;


import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

import static data.SQLQuery.DELETE_ALL_USER_NOTES;
import static data.SQLQuery.DELETE_USER_NOTE;
import static data.SQLQuery.GET_ALL_NOTES_BY_USER;
import static data.SQLQuery.SET_USER_NOTE;

public class DataBaseOperations {

    private static final DataBaseConnectionHelper DB = new DataBaseConnectionHelper();

    public static List<NoteDbObject> selectUserNotesByUserId(User user) {
        String userId = user.getId().toString();
        return DB.processingQuery(
                GET_ALL_NOTES_BY_USER.replace("%user_id%", userId)
        );
    }

    public static void insertNewNote(User user, String note) {
        String userId = user.getId().toString();
        String query = SET_USER_NOTE.replace("%user_id%", userId);
        DB.processingQueryWithoutResult(
                query.replace("%user_note%", note)
        );
    }

    public static void deleteNotes(User user) {
        String userId = user.getId().toString();
        DB.processingQueryWithoutResult(
                DELETE_ALL_USER_NOTES.replace("%user_id%", userId)
        );
    }

    public static void deleteNote(User user, String noteToDelete) {
        String userId = user.getId().toString();
        String query = DELETE_USER_NOTE.replace("%user_id%", userId);
        DB.processingQueryWithoutResult(
                query.replace("%user_note%", noteToDelete)
        );
    }
}
