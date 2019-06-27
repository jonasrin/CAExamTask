package lt.codeacademy.cauzduotis.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lt.codeacademy.cauzduotis.comment.Comment;
import lt.codeacademy.cauzduotis.comment.CommentView;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class EntryView {
    private long id;
    private String headline;
    @Length(max = 90)
    private String headlineText;
    private LocalDate entrySaveDate;
    private String entryText;
    private List<CommentView> commentViewList;
    private String authorName;

    public EntryView(long id, String headline, LocalDate entrySaveDate, String entryText, List<CommentView> commentViewList, String authorName) {
        this.id = id;
        this.headline = headline;
        this.entrySaveDate = entrySaveDate;
        this.entryText = entryText;
        this.commentViewList = commentViewList;
        this.authorName = authorName;
        if(entryText.length() < 90){
            this.headlineText = entryText.substring(0, entryText.length() );
        }else {
            this.headlineText = entryText.substring(0, 90);
        }


    }
}
