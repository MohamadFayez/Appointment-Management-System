package com.stc.appointment.exception;

import com.stc.appointment.common.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.method.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<?> handleBusinessException(final BusinessException e) {
        return new ResponseEntity<>(APIResponse.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(e.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<?> handleEntityNotFoundException(final ResourceNotFoundException e) {
        return new ResponseEntity<>(APIResponse.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(e.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
