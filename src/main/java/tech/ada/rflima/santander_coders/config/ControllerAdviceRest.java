package tech.ada.rflima.santander_coders.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.ada.rflima.santander_coders.exceptions.ErroPadrao;
import tech.ada.rflima.santander_coders.exceptions.UsuarioNaoEncontradoException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviceRest {

    @ExceptionHandler({UsuarioNaoEncontradoException.class})
    public ResponseEntity<ErroPadrao> handlerUsuarioNaoEncontrado(UsuarioNaoEncontradoException e) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setMensagem(e.getMessage());
        erroPadrao.setCodigoErro("USNT01");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErroPadrao> handlerExceptionGenerico(Exception e) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setMensagem(e.getMessage());
        erroPadrao.setCodigoErro("ERRO INTERNO SERVIDOR");
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroPadrao);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErroPadrao> handleClientError(MethodArgumentNotValidException e) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setMensagem(e.getMessage());
        erroPadrao.setCodigoErro("CLIENT ERROR");
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        errors.forEach((field, message) -> System.out.println("Erro no campo " + field + ": " + message));
        erroPadrao.setErrors(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadrao);
    }

}
