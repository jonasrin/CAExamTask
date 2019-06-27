package lt.codeacademy.cauzduotis.comment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lt.codeacademy.cauzduotis.AdminComment.AdminComment;
import lt.codeacademy.cauzduotis.entry.Entry;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String authorName;
    private String commentText;
    private LocalDate commentSaveDate;
    @ManyToOne
    private Entry entry;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AdminComment adminComment;

    public Comment(String authorName, String commentText, LocalDate commentSaveDate, Entry entry, AdminComment adminComment) {
        this.authorName = authorName;
        this.commentText = commentText;
        this.commentSaveDate = commentSaveDate;
        this.entry = entry;
        this.adminComment = adminComment;
    }

    public Comment() {
    }

    public Comment(String authorName, String commentText, LocalDate commentSaveDate) {
        this.authorName = authorName;
        this.commentText = commentText;
        this.commentSaveDate = commentSaveDate;
    }
}
