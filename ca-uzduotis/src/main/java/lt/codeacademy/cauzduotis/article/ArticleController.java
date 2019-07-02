package lt.codeacademy.cauzduotis.article;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "ArticleController", description = "REST APIs related to Article Entity!!!!")
@RestController
@RequestMapping(path = "/api/article")
@CrossOrigin("*")
public class ArticleController {
    private final ArticleService articleService;


    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(path = "/get-article")
    public List<ArticleView> getArticleList(){
        return articleService.getArticleList();
    }

    @GetMapping(path = "/get-article/{id}")
    public ArticleView getArticleById(@PathVariable(name = "id") long id){
        return articleService.getArticleById(id);
    }

    @PostMapping(path = "/create-article")
    public ArticleView addArticle(@Valid @RequestBody ArticleView articleView){
        return articleService.addArticle(articleView);
    }

    @DeleteMapping(path = "/delete-article/{id}")
    public HttpStatus deleteArticle(@PathVariable(name = "id") long id){
        return articleService.deleteArticle(id);
    }

    @PutMapping (path = "/edit-article/{id}")
    public ArticleView editArticle(@RequestBody ArticleView articleView, @PathVariable(name = "id") long id){
        return articleService.editArticle(articleView, id);
    }

}
