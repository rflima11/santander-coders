package tech.ada.rflima.santander_coders.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.ada.rflima.santander_coders.exceptions.ErroPadrao;
import tech.ada.rflima.santander_coders.exceptions.UsuarioNaoEncontradoException;

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
    public ResponseEntity<ErroPadrao> handlerUsuarioNaoEncontrado(Exception e) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setMensagem(e.getMessage());
        erroPadrao.setCodigoErro("ERRO INTERNO SERVIDOR");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroPadrao);
    }

}
