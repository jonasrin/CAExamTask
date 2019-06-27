package lt.codeacademy.cauzduotis.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lt.codeacademy.cauzduotis.comment.Comment;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Prašau, nurodykite antraštę.")
    private String headline;
    @Length(max = 90)
    private String headlineText;
    private LocalDate entrySaveDate;
    @NotEmpty(message = "Prašau, nurodykite straipsnio tekstą.")
    private String entryText;
    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> commentList;
    @NotEmpty(message = "Prašau, nurodykite straipsnio autorių.")
    private String authorName;

    public Entry(String headline, @Length(max = 90) String headlineText, LocalDate entrySaveDate, String entryText, List<Comment> commentList, String authorName) {
        this.headline = headline;
        this.headlineText = headlineText;
        this.entrySaveDate = entrySaveDate;
        this.entryText = entryText;
        this.commentList = commentList;
        this.authorName = authorName;
    }

    public Entry(String headline, @Length(max = 90) String headlineText, LocalDate entrySaveDate, String entryText, String authorName) {
        this.headline = headline;
        this.headlineText = headlineText;
        this.entrySaveDate = entrySaveDate;
        this.entryText = entryText;
        this.authorName = authorName;
    }

    public Entry() {
    }
}
