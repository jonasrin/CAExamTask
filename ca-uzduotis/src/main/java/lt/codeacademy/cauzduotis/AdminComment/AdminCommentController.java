package lt.codeacademy.cauzduotis.AdminComment;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "AdminCommentController", description = "REST APIs related to AdminComment Entity!!!!")
@RestController
@RequestMapping(path = "/api/admincomment")
@CrossOrigin("*")
public class AdminCommentController {
    private final AdminCommentService adminCommentService;

    @Autowired
    public AdminCommentController(AdminCommentService adminCommentService) {
        this.adminCommentService = adminCommentService;
    }

    @PostMapping(path = "/addcomment/{id}")
    public AdminCommentView addComment(@Valid @RequestBody AdminCommentView adminCommentView, @PathVariable(name = "id") long id){
        return adminCommentService.addComment(adminCommentView, id);
    }

}
