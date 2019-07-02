package lt.codeacademy.cauzduotis.comment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lt.codeacademy.cauzduotis.AdminComment.AdminComment;
import lt.codeacademy.cauzduotis.article.Article;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDate getCommentSaveDate() {
        return commentSaveDate;
    }

    public void setCommentSaveDate(LocalDate commentSaveDate) {
        this.commentSaveDate = commentSaveDate;
    }

//    public Article getArticle() {
//        return article;
//    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public AdminComment getAdminComment() {
        return adminComment;
    }

    public void setAdminComment(AdminComment adminComment) {
        this.adminComment = adminComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(authorName, comment.authorName) &&
                Objects.equals(commentText, comment.commentText) &&
                Objects.equals(commentSaveDate, comment.commentSaveDate) &&
                Objects.equals(article, comment.article) &&
                Objects.equals(adminComment, comment.adminComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName, commentText, commentSaveDate, article, adminComment);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", commentText='" + commentText + '\'' +
                ", commentSaveDate=" + commentSaveDate +
                ", adminComment=" + adminComment +
                '}';
    }


}
