package hr.khorvat.blink.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(RuntimeException e) {
        String logRef = UUID.randomUUID().toString();
        log.error("logRef: " + logRef + " : " + e.getMessage(), e);
        ErrorResponse response = new ErrorResponse(e.getMessage(), logRef);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleOtherExceptions(Exception e) {
        String logRef = UUID.randomUUID().toString();
        log.error("logRef: " + logRef + " : " + e.getMessage(), e);
        ErrorResponse response = new ErrorResponse(e.getMessage(), logRef);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
