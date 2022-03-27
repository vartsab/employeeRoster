package com.vartsab.employeeroster.exceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//400
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {}
