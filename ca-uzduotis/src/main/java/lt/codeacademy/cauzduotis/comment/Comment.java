package lt.codeacademy.cauzduotis.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.cauzduotis.entry.Entry;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

@Data
public class Comment {

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
}
