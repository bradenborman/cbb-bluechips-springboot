package Borman.cbbbluechips.controllers.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

//    @ExceptionHandler(CommunicationsException.class)
//    public ResponseEntity<Object> catchError(final java.io.EOFException e) {
//        logger.info("ERROR WAS CAUGHT WITH CONNECTION TO DATABASE -- sending to portfolio");
//        return ResponseEntity.status(HttpStatus.SEE_OTHER).build();
//    }

}