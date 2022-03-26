package com.vartsab.employeeroster.exceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//500
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalSrvErr extends RuntimeException {}