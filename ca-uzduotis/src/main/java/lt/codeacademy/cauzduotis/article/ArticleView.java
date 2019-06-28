package lt.codeacademy.cauzduotis.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lt.codeacademy.cauzduotis.comment.CommentView;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class ArticleView {
    private long id;

    @NotEmpty(message = "Please, enter headline.")
    private String headline;
    @Length(max = 90)
    private String headlineText;
    private LocalDate articleSaveDate;
    @NotEmpty(message = "Please, enter article text.")
    private String articleText;
    private List<CommentView> commentViewList;
    @NotEmpty(message = "Please, enter author name.")
    private String authorName;

//    public ArticleView(long id, String headline, LocalDate articleSaveDate, String articleText, List<CommentView> commentViewList, String authorName) {
//        this.id = id;
//        this.headline = headline;
//        this.articleSaveDate = articleSaveDate;
//        this.articleText = articleText;
//        this.commentViewList = commentViewList;
//        this.authorName = authorName;

//    }


    public ArticleView(long id, @NotEmpty(message = "Please, enter headline.") String headline, LocalDate articleSaveDate, @NotEmpty(message = "Please, enter article text.") String articleText, List<CommentView> commentViewList, @NotEmpty(message = "Please, enter author name.") String authorName) {
        this.id = id;
        this.headline = headline;
        this.articleSaveDate = articleSaveDate;
        this.articleText = articleText;
        this.commentViewList = commentViewList;
        this.authorName = authorName;
        if (articleText.length() < 90) {
            this.headlineText = articleText.substring(0, articleText.length());
        } else {
            this.headlineText = articleText.substring(0, 90);
        }
    }
}
