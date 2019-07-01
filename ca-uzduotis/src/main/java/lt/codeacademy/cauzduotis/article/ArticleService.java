package lt.codeacademy.cauzduotis.article;

import lt.codeacademy.cauzduotis.comment.Comment;
import lt.codeacademy.cauzduotis.comment.CommentView;

import lt.codeacademy.cauzduotis.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    Logger logger = LoggerFactory.getLogger(ArticleService.class);
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleView> getArticleList() {
        List<ArticleView> articleViewList = articleRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());

        logger.info("Got entries count: " + articleViewList.size());
        return articleViewList;
    }

    public ArticleView addArticle(ArticleView articleView) {
        articleView.setArticleSaveDate(LocalDate.now());
        ArticleView view = mapToView(articleRepository.save(mapFromArticle(articleView)));
        logger.info("Article was added" + articleView.toString());
        return view;
    }

    public HttpStatus deleteArticle(long id) {
        articleRepository.delete(findArticleById(id));
        logger.info("Article with id="+id +" was deleted.");
        return HttpStatus.OK;
    }

    public ArticleView editArticle(ArticleView articleView, long id) {
        Article article = findArticleById(id);
        if (articleView.getAuthorName() != null) {
            article.setAuthorName(articleView.getAuthorName());
        }
        if (articleView.getArticleText() != null) {
            article.setArticleText(articleView.getArticleText());
        }
        if (articleView.getArticleSaveDate() != null) {
            article.setArticleSaveDate(articleView.getArticleSaveDate());
        }
        if (articleView.getHeadlineText() != null) {
            article.setHeadlineText(articleView.getHeadlineText());
        }
        if (articleView.getHeadline() != null) {
            article.setHeadline(articleView.getHeadline());
        }
        ArticleView view = mapToView(articleRepository.save(article));
        logger.info("Article with id=" + id + " was edited. " + article.toString());
        return view;
    }

    private Article findArticleById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(
                        () ->
                                new NotFoundException("Article with id=" + id + " was not found. "));
    }

    private Article mapFromArticle(ArticleView articleView) {
        return new Article(articleView.getHeadline(), articleView.getHeadlineText(), articleView.getArticleSaveDate(), articleView.getArticleText(), Collections.EMPTY_LIST, articleView.getAuthorName());
    }


    private ArticleView mapToView(Article article) {
        List<CommentView> commentViews = article.getCommentList().stream()
                .map(this::mapToCommentView)
                .collect(Collectors.toList());
        return new ArticleView(article.getId(), article.getHeadline(), article.getArticleSaveDate(), article.getArticleText(), commentViews, article.getAuthorName());
    }

    private CommentView mapToCommentView(Comment comment) {
        return new CommentView(comment.getId(), comment.getAuthorName(), comment.getCommentText(), comment.getCommentSaveDate(), comment.getAdminComment());
    }
}
