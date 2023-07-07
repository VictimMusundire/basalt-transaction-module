package com.basalt.basalttransactionmodule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Victim Musundire
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountNotFoundException extends RuntimeException{
        private String message;
        public AccountNotFoundException(String message){
            super(message);
        }

    }
