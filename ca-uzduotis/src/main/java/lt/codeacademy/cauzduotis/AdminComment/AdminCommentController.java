package lt.codeacademy.cauzduotis.AdminComment;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "AdminCommentController", description = "REST APIs related to AdminComment Entity!!!!")
@RestController
@RequestMapping(path = "/api/admincomment")
public class AdminCommentController {
    private final AdminCommentService adminCommentService;

    @Autowired
    public AdminCommentController(AdminCommentService adminCommentService) {
        this.adminCommentService = adminCommentService;
    }

    @PostMapping(path = "/addcomment")
    public AdminCommentView addComment(@Valid @RequestBody AdminCommentView adminCommentView){
        return adminCommentService.addComment(adminCommentView);
    }

}
