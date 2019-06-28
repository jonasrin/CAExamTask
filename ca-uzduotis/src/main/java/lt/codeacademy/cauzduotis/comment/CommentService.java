package lt.codeacademy.cauzduotis.comment;

import lt.codeacademy.cauzduotis.article.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    Logger logger = LoggerFactory.getLogger(CommentService.class);
    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<CommentView> getCommentsList() {
        List<CommentView> commentViewList = commentsRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
        logger.info("Got comments count: " + commentViewList.size());
        return commentViewList;
    }

    public CommentView createComment(CommentView commentView) {
        CommentView view = mapToView(commentsRepository.save(mapFromView(commentView)));
        logger.info("Comment was created." + view.toString());
        return view;
    }

    private CommentView mapToView(Comment comment) {
        return new CommentView(comment.getId(), comment.getAuthorName(), comment.getCommentText(), comment.getCommentSaveDate(), comment.getAdminComment());
    }

    private Comment mapFromView(CommentView commentView) {
        return new Comment(commentView.getAuthorName(), commentView.getCommentText(), LocalDate.now());
    }
}
