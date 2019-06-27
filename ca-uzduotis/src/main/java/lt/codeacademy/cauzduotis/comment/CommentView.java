package lt.codeacademy.cauzduotis.comment;

import lombok.Data;
import lt.codeacademy.cauzduotis.entry.Entry;
import java.time.LocalDate;

@Data
public class CommentView {
    private long id;

    private String authorName;
    private String commentText;
    private LocalDate commentSaveDate;
    private Entry entry;
    private AdminComment adminComment;

    public CommentView(long id, String authorName, String commentText, LocalDate commentSaveDate, Entry entry, AdminComment adminComment) {
        this.id = id;
        this.authorName = authorName;
        this.commentText = commentText;
        this.commentSaveDate = commentSaveDate;
        this.entry = entry;
        this.adminComment = adminComment;
    }

    public CommentView() {
    }
}
