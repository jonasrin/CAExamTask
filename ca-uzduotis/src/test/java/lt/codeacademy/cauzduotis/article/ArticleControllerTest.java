package lt.codeacademy.cauzduotis.article;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ArticleControllerTest {

    private static String APIENDPOINT = "http://localhost:";
    private static String CREATEARTICLEENDPOINT = "/api/article/create-article";
    private static String DELETEARTICLEENDPOINT = "/api/article/delete-article/";
    private static String GETARTICLESENDPOINT = "/api/article/get-article/";
    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ArticleRepository articleRepository;

    @Before
    public void beforeEach() {
        articleRepository.deleteAll();
//        articleRepository.save(new Article("test-headline", "test-headlineText", LocalDate.now(), "test-articleText", "test-author"));
    }

    @Test
    public void testArticleController_createArticle_shouldReturnNewArticle() {
        String requestURL = APIENDPOINT + port + CREATEARTICLEENDPOINT;
        ArticleView article = new ArticleView(0, "test-headline", LocalDate.now(), "test-articleText", Collections.EMPTY_LIST, "test-author");
        ResponseEntity<ArticleView> responseEntity = restTemplate.postForEntity(requestURL, article, ArticleView.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("test-headline", responseEntity.getBody().getHeadline());
        assertEquals("test-articleText", responseEntity.getBody().getArticleText());
        assertEquals("test-author", responseEntity.getBody().getAuthorName());
    }

    @Test
    public void testArticleController_deleteArticle_shouldDeleteArticle() throws Exception {
        Article save = articleRepository.save(new Article("test-headline", "test-headlineText", LocalDate.now(), "test-articleText", "test-author"));
        String deleteUrl = APIENDPOINT + port + DELETEARTICLEENDPOINT + save.getId();
        String requestURL = APIENDPOINT + port + GETARTICLESENDPOINT;
        ResultActions resultActions = this.mockMvc.perform(delete(deleteUrl)).andExpect(status().is2xxSuccessful());
        ParameterizedTypeReference<List<ArticleView>> typeReference = new ParameterizedTypeReference<List<ArticleView>>() {
        };
        ResponseEntity<List<ArticleView>> responseEntity = restTemplate.exchange(requestURL, HttpMethod.GET, null, typeReference);
        assertEquals(0, responseEntity.getBody().size());
    }


}