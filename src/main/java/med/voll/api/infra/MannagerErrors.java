package med.voll.api.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
/*
 * Class para manejo de errores para direccionar 404 Not found
 */
@RestControllerAdvice
public class MannagerErrors {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> errorHandler404() {
        return ResponseEntity.notFound().build();
    }
}
