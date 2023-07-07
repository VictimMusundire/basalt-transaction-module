package com.basalt.basalttransactionmodule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Victim Musundire
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountAlreadyExistsException extends RuntimeException{
        private String message;
        public AccountAlreadyExistsException(String message){
            super(message);
        }

    }
