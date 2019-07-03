package lt.codeacademy.cauzduotis.comment;

import lt.codeacademy.cauzduotis.article.Article;
import lt.codeacademy.cauzduotis.article.ArticleRepository;
import lt.codeacademy.cauzduotis.article.ArticleService;
import lt.codeacademy.cauzduotis.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    Logger logger = LoggerFactory.getLogger(CommentService.class);
    private final CommentsRepository commentsRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public CommentService(CommentsRepository commentsRepository, ArticleRepository articleRepository) {
        this.commentsRepository = commentsRepository;
        this.articleRepository = articleRepository;
    }

    public List<CommentView> getCommentsList() {
        List<CommentView> commentViewList = commentsRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
        logger.info("Got comments count: " + commentViewList.size());
        return commentViewList;
    }

    public CommentView createComment(CommentView commentView, long id) {
        Comment comment = mapFromView(commentView);
        Article article = articleRepository.findById(id).orElseThrow(() -> new NotFoundException("Article with id=" + id + " was not found. "));
        article.addComment(comment);
        comment = commentsRepository.save(comment);
        logger.info("Comment was created." + comment.toString());
        return mapToView(comment);
    }

    private CommentView mapToView(Comment comment) {
        return new CommentView(comment.getId(), comment.getAuthorName(), comment.getCommentText(), comment.getCommentSaveDate(), comment.getAdminComment());
    }

    private Comment mapFromView(CommentView commentView) {
        return new Comment( commentView.getAuthorName(), commentView.getCommentText(), LocalDate.now());
    }
}
