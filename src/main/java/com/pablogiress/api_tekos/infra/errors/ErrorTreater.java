package com.pablogiress.api_tekos.infra.errors;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorTreater {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(MethodArgumentNotValidException e){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DataErrorValidation::new).toList();

        return ResponseEntity.badRequest().body(errores);
    }


    private record DataErrorValidation(String campo, String error){
        public DataErrorValidation(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
