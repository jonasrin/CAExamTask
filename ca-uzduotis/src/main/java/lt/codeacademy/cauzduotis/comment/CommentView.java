package lt.codeacademy.cauzduotis.comment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lt.codeacademy.cauzduotis.AdminComment.AdminComment;
import lt.codeacademy.cauzduotis.article.Article;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode
public class CommentView {
    private long id;
    @NotEmpty(message = "Prašau, nurodykite savo vardą.")
    private String authorName;
    @NotEmpty(message = "Prašau, įrašykite komentarą")
    private String commentText;
    private LocalDate commentSaveDate;
    private AdminComment adminComment;


    public CommentView() {
    }

    public CommentView(long id, String authorName, String commentText, LocalDate commentSaveDate, AdminComment adminComment) {
        this.id = id;
        this.authorName = authorName;
        this.commentText = commentText;
        this.commentSaveDate = commentSaveDate;
        this.adminComment = adminComment;
    }
}
