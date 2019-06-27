package lt.codeacademy.cauzduotis.entry;

import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.cauzduotis.comment.Comment;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Data
public class EntryView {
    private long id;
    private String headline;
    @Length(max = 90)
    private String headlineText;
    private LocalDate entrySaveDate;
    private String entryText;
    private List<Comment> commentList;
    private String authorName;

    public EntryView(long id, String headline, LocalDate entrySaveDate, String entryText, List<Comment> commentList, String authorName) {
        this.id = id;
        this.headline = headline;
        this.entrySaveDate = entrySaveDate;
        this.entryText = entryText;
        this.commentList = commentList;
        this.authorName = authorName;
        if(entryText.length() < 90){
            this.headlineText = entryText.substring(0, entryText.length() );
        }else {
            this.headlineText = entryText.substring(0, 90);
        }


    }
}
