package lt.codeacademy.cauzduotis.AdminComment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@ToString
@EqualsAndHashCode
@Data
public class AdminCommentView {
    private long id;

    @NotEmpty(message = "Enter username")
    private String authorName;
    @NotEmpty(message = "Enter your answer")
    private String commentText;

    public AdminCommentView(long id, @NotEmpty(message = "Enter username") String authorName, @NotEmpty(message = "Enter your answer") String commentText) {
        this.id = id;
        this.authorName = authorName;
        this.commentText = commentText;
    }
}
