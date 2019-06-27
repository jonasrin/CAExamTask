package lt.codeacademy.cauzduotis.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "/get-comments")
    public List<CommentView> getCommentsList(){
        return commentService.getCommentsList();
    }

    @PostMapping (path = "/create-comment")
    public CommentView createComment(@RequestBody CommentView commentView){
        return commentService.createComment(commentView);
    }
}
