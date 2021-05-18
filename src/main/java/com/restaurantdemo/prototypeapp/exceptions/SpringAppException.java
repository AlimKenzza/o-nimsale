package com.restaurantdemo.prototypeapp.exceptions;

import org.springframework.http.HttpStatus;

public class SpringAppException extends RuntimeException {

    public SpringAppException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }




    public SpringAppException(String exMessage) {
        super(exMessage);
    }

}
