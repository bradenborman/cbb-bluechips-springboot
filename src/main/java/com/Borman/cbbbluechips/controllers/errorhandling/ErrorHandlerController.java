package com.Borman.cbbbluechips.controllers.errorhandling;

import com.Borman.cbbbluechips.exceptions.NoUserPresent;
import com.Borman.cbbbluechips.services.CookieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler(java.io.EOFException.class)
    public String catchError(final java.io.EOFException e) {
        logger.info("ERROR WAS CAUGHT WITH CONNECTION TO DATABASE -- sending to portfolio");
        return "redirect:/portfolio";
    }

    @ExceptionHandler(NoUserPresent.class)
    public String noUserPresent(final NoUserPresent e) {
        return "redirect:../?wasError=true&emailAttempted=" + e.getEmailAttempted();
    }

}