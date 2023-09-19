package learn.field_agent.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException; //class to handle Data Integrity issues

@ControllerAdvice
public class GlobalErrorHandler {

    // Determine the most precise exception for data integrity failures
    // and handle it with a specific data integrity message.
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleException(SQLIntegrityConstraintViolationException ex) {
        return new ResponseEntity<>("Data integrity violation: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Something broke, cry about it.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
