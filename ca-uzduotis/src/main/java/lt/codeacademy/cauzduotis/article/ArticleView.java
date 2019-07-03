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
import java.util.Objects;


public class ArticleView {
    private long id;

    @NotEmpty(message = "Please, enter headline.")
    private String headline;
//    @Length(max = 90)
    private String headlineText;
    private LocalDate articleSaveDate;
    @NotEmpty(message = "Please, enter article text.")
    private String articleText;
    private List<CommentView> commentViewList;
    @NotEmpty(message = "Please, enter author name.")
    private String authorName;



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
            this.headlineText = articleText.substring(0, 80);
        }
    }

    public ArticleView() {
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

    public List<CommentView> getCommentViewList() {
        return commentViewList;
    }

    public void setCommentViewList(List<CommentView> commentViewList) {
        this.commentViewList = commentViewList;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleView that = (ArticleView) o;
        return id == that.id &&
                Objects.equals(headline, that.headline) &&
                Objects.equals(headlineText, that.headlineText) &&
                Objects.equals(articleSaveDate, that.articleSaveDate) &&
                Objects.equals(articleText, that.articleText) &&
                Objects.equals(commentViewList, that.commentViewList) &&
                Objects.equals(authorName, that.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, headline, headlineText, articleSaveDate, articleText, commentViewList, authorName);
    }

    @Override
    public String toString() {
        return "ArticleView{" +
                "id=" + id +
                ", headline='" + headline + '\'' +
                ", headlineText='" + headlineText + '\'' +
                ", articleSaveDate=" + articleSaveDate +
                ", articleText='" + articleText + '\'' +
                ", commentViewList=" + commentViewList +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
