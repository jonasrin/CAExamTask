package lt.codeacademy.cauzduotis.comment;

import io.swagger.annotations.Api;
import lt.codeacademy.cauzduotis.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Api(value = "CommentController", description = "REST APIs related to Comment Entity!!!!")
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
    public CommentView createComment(@Valid @RequestBody CommentView commentView){
        return commentService.createComment(commentView);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void notFound() {

    }
}
