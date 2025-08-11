package com.gamevault.gamevault.config;

import com.gamevault.gamevault.exception.UsernameOrPasswordInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(UsernameOrPasswordInvalidException.class)
        public String handleNotFoundException(UsernameOrPasswordInvalidException ex){
            return ex.getMessage(); //retorna a mensagem de erro da exceção
        }

}
