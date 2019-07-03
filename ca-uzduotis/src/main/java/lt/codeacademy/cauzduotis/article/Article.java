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
import java.util.Objects;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @NotEmpty(message = "Please, enter headline.")
    private String headline;
//    @Length(max = 90)
    @NonNull
    private String headlineText;
    @NonNull
    private LocalDate articleSaveDate;
    @NonNull
    @Lob
//    @Column( length = 100000 )
    private String articleText;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id",
            foreignKey = @ForeignKey(name = "article_article_list_to_comment_id_fkey"))
    private List<Comment> commentList;
    @NonNull
    private String authorName;
//    @Length(max = 90)
    public Article(String headline,  String headlineText, LocalDate articleSaveDate, String entryText, List<Comment> commentList, String authorName) {
        this.headline = headline;
        this.headlineText = headlineText;
        this.articleSaveDate = articleSaveDate;
        this.articleText = entryText;
        this.commentList = commentList;
        this.authorName = authorName;
    }
//    @Length(max = 90)
    public Article(String headline,  String headlineText, LocalDate articleSaveDate, String entryText, String authorName) {
        this.headline = headline;
        this.headlineText = headlineText;
        this.articleSaveDate = articleSaveDate;
        this.articleText = entryText;
        this.authorName = authorName;
    }

    public Article() {
    }

    public void addComment(Comment comment){
        commentList.add(comment);
        comment.setArticle(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getHeadlineText() {
        return headlineText;
    }

    public void setHeadlineText(String headlineText) {
        this.headlineText = headlineText;
    }

    public LocalDate getArticleSaveDate() {
        return articleSaveDate;
    }

    public void setArticleSaveDate(LocalDate articleSaveDate) {
        this.articleSaveDate = articleSaveDate;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", headline='" + headline + '\'' +
                ", headlineText='" + headlineText + '\'' +
                ", articleSaveDate=" + articleSaveDate +
                ", articleText='" + articleText + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id &&
                Objects.equals(headline, article.headline) &&
                Objects.equals(headlineText, article.headlineText) &&
                Objects.equals(articleSaveDate, article.articleSaveDate) &&
                Objects.equals(articleText, article.articleText) &&
                Objects.equals(commentList, article.commentList) &&
                Objects.equals(authorName, article.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, headline, headlineText, articleSaveDate, articleText, commentList, authorName);
    }
}
