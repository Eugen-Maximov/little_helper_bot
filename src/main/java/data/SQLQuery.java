package data;

public class SQLQuery {

    //TODO change to prod db table name
    private static final String TABLE_NAME = "local_debug_table";

    public static final String GET_ALL_NOTES_BY_USER = "SELECT user_id, user_note " +
            "FROM " + TABLE_NAME + " " +
            "WHERE user_id = %user_id% " +
            "ORDER BY note_id";

    public static final String SET_USER_NOTE = "INSERT INTO " + TABLE_NAME + " (user_id, user_note)" +
            "VALUES (%user_id%, '%user_note%')";

    public static final String DELETE_USER_NOTE = "DELETE FROM " + TABLE_NAME + " " +
            "WHERE user_id = %user_id% AND user_note = '%user_note%'";

    public static final String DELETE_ALL_USER_NOTES = "DELETE FROM " + TABLE_NAME + " " +
            "WHERE user_id = %user_id%";
}
