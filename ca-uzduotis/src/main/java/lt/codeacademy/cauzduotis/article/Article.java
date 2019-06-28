package lt.codeacademy.cauzduotis.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lt.codeacademy.cauzduotis.comment.Comment;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @NotEmpty(message = "Please, enter headline.")
    private String headline;
    @Length(max = 90)
    @NonNull
    private String headlineText;
    @NonNull
    private LocalDate articleSaveDate;
    @NonNull
    private String articleText;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_id",
            foreignKey = @ForeignKey(name = "article_article_list_to_comment_id_fkey"))
    private List<Comment> commentList;
    @NonNull
    private String authorName;

    public Article(String headline, @Length(max = 90) String headlineText, LocalDate articleSaveDate, String entryText, List<Comment> commentList, String authorName) {
        this.headline = headline;
        this.headlineText = headlineText;
        this.articleSaveDate = articleSaveDate;
        this.articleText = entryText;
        this.commentList = commentList;
        this.authorName = authorName;
    }

    public Article(String headline, @Length(max = 90) String headlineText, LocalDate articleSaveDate, String entryText, String authorName) {
        this.headline = headline;
        this.headlineText = headlineText;
        this.articleSaveDate = articleSaveDate;
        this.articleText = entryText;
        this.authorName = authorName;
    }

    public Article() {
    }
}
