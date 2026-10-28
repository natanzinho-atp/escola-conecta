package br.com.techsolutions.escolaconecta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            RecursoNaoEncontradoException.class
    )
    public ResponseEntity<String>
        tratarRecursosNaoEncontrado(RecursoNaoEncontradoException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<String> tratarValidacao(MethodArgumentNotValidException ex){
        String mensagem = ex
                .getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();



        return ResponseEntity.badRequest().body(mensagem);
    }
}
