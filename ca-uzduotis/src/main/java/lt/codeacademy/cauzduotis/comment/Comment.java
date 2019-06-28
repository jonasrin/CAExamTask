package lt.codeacademy.cauzduotis.comment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lt.codeacademy.cauzduotis.AdminComment.AdminComment;
import lt.codeacademy.cauzduotis.article.Article;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String authorName;
    private String commentText;
    private LocalDate commentSaveDate;
    @ManyToOne
    @JoinColumn(name = "article_id",
            foreignKey = @ForeignKey(name = "comment_comment_id_to_article_article_id_fkey"))
    private Article article;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_comment_id",
            foreignKey = @ForeignKey(name = "comment_to_admin_comment_id_fkey"))
    private AdminComment adminComment;

    public Comment(String authorName, String commentText, LocalDate commentSaveDate, Article article, AdminComment adminComment) {
        this.authorName = authorName;
        this.commentText = commentText;
        this.commentSaveDate = commentSaveDate;
        this.article = article;
        this.adminComment = adminComment;
    }

    public Comment() {
    }

    public Comment(String authorName, String commentText, LocalDate commentSaveDate) {
        this.authorName = authorName;
        this.commentText = commentText;
        this.commentSaveDate = commentSaveDate;
    }
}
