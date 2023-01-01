package br.com.aaz.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.aaz.dto.ErrorResponseDTO;
import br.com.aaz.exception.AppException;


/**
 * Global Exception Handler
 * Para capturar de acordo com a classe ou subclasse (@ExceptionHandler(<exceptionClasss>.class)
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException exception) {
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponseDTO("Usuário e/ou senha inválidos"));
    }
	
	@ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<Object> handleAppException(AppException exception) {
    	
    	exception.printStackTrace();
    	
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponseDTO(exception.getMessage()));
    }
	
	
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleAllOtherErrors(Exception exception) {
    	
    	exception.printStackTrace();
    	
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponseDTO(exception.getMessage()));
    }
    
    

}