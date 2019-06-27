package lt.codeacademy.cauzduotis.entry;

import lombok.Data;
import lt.codeacademy.cauzduotis.comment.Comment;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String headline;
    @Length(max = 90)
    private String headlineText;
    private LocalDate entrySaveDate;
    private String entryText;
    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> commentList;
    private String authorName;

    public Entry(String headline, @Length(max = 90) String headlineText, LocalDate entrySaveDate, String entryText, List<Comment> commentList, String authorName) {
        this.headline = headline;
        this.headlineText = headlineText;
        this.entrySaveDate = entrySaveDate;
        this.entryText = entryText;
        this.commentList = commentList;
        this.authorName = authorName;
    }

    public Entry() {
    }
}
