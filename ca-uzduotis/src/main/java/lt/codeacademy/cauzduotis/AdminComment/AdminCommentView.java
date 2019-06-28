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
    private String userName;
    @NotEmpty(message = "Enter your answer")
    private String answerText;

    public AdminCommentView(long id, @NotEmpty(message = "Enter username") String userName, @NotEmpty(message = "Enter your answer") String answerText) {
        this.id = id;
        this.userName = userName;
        this.answerText = answerText;
    }
}
