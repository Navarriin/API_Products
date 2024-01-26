package api_products.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationHandlerException extends ResponseEntityExceptionHandler {

    private final HttpStatus notFound = HttpStatus.NOT_FOUND;
    private final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DefaultException> handlerNoSuchElementException(NoSuchElementException ex) {
        DefaultException defaultException = new DefaultException(notFound.value(), "Element not found");
        return ResponseEntity.status(notFound).body(defaultException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultException> handlerException(Exception ex) {
        DefaultException defaultException = new DefaultException(badRequest.value(), "error");
        return ResponseEntity.status(badRequest).body(defaultException);
    }
}
