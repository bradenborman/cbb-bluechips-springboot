package com.Borman.cbbbluechips.controllers.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler(java.io.EOFException.class)
    public String catchError(final java.io.EOFException e) {
        logger.info("ERROR WAS CAUGHT WITH CONNECTION TO DATABASE -- sending to portfolio");
        return "redirect:/portfolio";
    }

}