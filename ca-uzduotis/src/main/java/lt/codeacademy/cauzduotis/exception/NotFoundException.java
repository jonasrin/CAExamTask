package lt.codeacademy.cauzduotis.exception;

import lt.codeacademy.cauzduotis.article.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
