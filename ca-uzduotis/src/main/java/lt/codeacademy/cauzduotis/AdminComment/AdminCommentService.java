package lt.codeacademy.cauzduotis.AdminComment;

import lt.codeacademy.cauzduotis.article.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class AdminCommentService {
    Logger logger = LoggerFactory.getLogger(ArticleService.class);

    private final AdminCommentRepository adminCommentRepository;

    public AdminCommentService(AdminCommentRepository adminCommentRepository) {
        this.adminCommentRepository = adminCommentRepository;
    }

    public AdminCommentView addComment(AdminCommentView adminCommentView) {
        AdminCommentView commentView = mapFromAdminComment(adminCommentRepository.save(mapToView(adminCommentView)));
        logger.info("Comment by " + adminCommentView.getUserName() + "was added. " + adminCommentView.toString());
        return commentView;
    }

    private AdminCommentView mapFromAdminComment(AdminComment save) {
        return new AdminCommentView(save.getId(), save.getUserName(), save.getAnswerText());
    }

    private  AdminComment mapToView(AdminCommentView adminCommentView) {
        return new AdminComment(adminCommentView.getUserName(), adminCommentView.getAnswerText());
    }
}
