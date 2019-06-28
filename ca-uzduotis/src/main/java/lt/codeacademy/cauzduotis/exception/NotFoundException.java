package lt.codeacademy.cauzduotis.exception;

import lt.codeacademy.cauzduotis.article.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotFoundException extends RuntimeException {

    Logger logger = LoggerFactory.getLogger(NotFoundException.class);
    public NotFoundException(String message) {
        super(message);
        logger.error(message);
    }
}
