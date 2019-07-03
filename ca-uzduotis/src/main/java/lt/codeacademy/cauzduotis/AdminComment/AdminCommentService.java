package lt.codeacademy.cauzduotis.AdminComment;

import lt.codeacademy.cauzduotis.article.ArticleService;
import lt.codeacademy.cauzduotis.comment.Comment;
import lt.codeacademy.cauzduotis.comment.CommentsRepository;
import lt.codeacademy.cauzduotis.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AdminCommentService {
    Logger logger = LoggerFactory.getLogger(ArticleService.class);

    private final AdminCommentRepository adminCommentRepository;
    private final CommentsRepository commentsRepository;

    public AdminCommentService(AdminCommentRepository adminCommentRepository, CommentsRepository commentsRepository) {
        this.adminCommentRepository = adminCommentRepository;
        this.commentsRepository = commentsRepository;
    }

    public AdminCommentView addComment(AdminCommentView adminCommentView, long id) {
        Comment comment = commentsRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment with this id: "+ id + " was not found"));
        comment.setAdminComment(mapToView(adminCommentView));
        commentsRepository.save(comment);
        AdminComment commentView = comment.getAdminComment();
        logger.info("Admin Comment by " + commentView.getAuthorName() + "was added. " + commentView.toString());
        return mapFromAdminComment(commentView);
    }

    private AdminCommentView mapFromAdminComment(AdminComment save) {
        return new AdminCommentView(save.getId(), save.getAuthorName(), save.getCommentText());
    }

    private  AdminComment mapToView(AdminCommentView adminCommentView) {
        return new AdminComment(adminCommentView.getAuthorName(), adminCommentView.getCommentText());
    }
}
