package helpers.db;

public class NoteDbObject {

    long userId;
    String userNote;

    public NoteDbObject(long userId, String userNote) {
        this.userId = userId;
        this.userNote = userNote;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}
