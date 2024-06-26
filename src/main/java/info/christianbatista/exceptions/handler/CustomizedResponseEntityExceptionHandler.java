package info.christianbatista.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import info.christianbatista.exceptions.ExceptionResponse;
import info.christianbatista.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> HandleAllExceptions(
			Exception ex, WebRequest request) {
	ExceptionResponse exceptionResponse = new ExceptionResponse(
			new Date(),
			ex.getMessage(),
			request.getDescription(false));
	return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> HandleBadRequestExceptions(
			Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
}
}