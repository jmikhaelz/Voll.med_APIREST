package med.voll.api.infra.exceptions;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

/*
 * Class para manejo de errores
 * Simplificar el JSON devuelto por la API en casos de error de validación de Bean Validation.
 */
@RestControllerAdvice
public class MannagerErrors {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> errorHandler404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DataErrorValid>> errorHandlerBlank(MethodArgumentNotValidException ex) {
        var errores = ex.getFieldErrors().stream()
                .map(DataErrorValid::new)
                .toList();
        return ResponseEntity.badRequest().body(errores);
    }

    public record DataErrorValid(
            String campo,
            String mensaje) {
        public DataErrorValid(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
