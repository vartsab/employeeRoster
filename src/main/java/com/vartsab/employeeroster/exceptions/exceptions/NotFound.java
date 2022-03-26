package com.vartsab.employeeroster.exceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


    //404
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public class NotFound extends RuntimeException {}






