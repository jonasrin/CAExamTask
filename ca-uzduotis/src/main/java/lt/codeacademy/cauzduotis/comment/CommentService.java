package lt.codeacademy.cauzduotis.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<CommentView> getCommentsList() {
       return commentsRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    private CommentView mapToView(Comment comment) {
        return new CommentView(comment.getId(), comment.getAuthorName(), comment.getCommentText(), comment.getCommentSaveDate(), comment.getAdminComment());
    }

    public CommentView createComment(CommentView commentView) {
        return mapToView(commentsRepository.save(mapFromView(commentView)));
    }

    private Comment mapFromView(CommentView commentView){
        return new Comment(commentView.getAuthorName(), commentView.getCommentText(), LocalDate.now());
    }
}
