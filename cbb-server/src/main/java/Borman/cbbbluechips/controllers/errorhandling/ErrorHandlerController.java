package Borman.cbbbluechips.controllers.errorhandling;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler(CommunicationsException.class)
    public String catchError(final java.io.EOFException e) {
        logger.info("ERROR WAS CAUGHT WITH CONNECTION TO DATABASE -- sending to portfolio");
        return "redirect:/portfolio";
    }

}