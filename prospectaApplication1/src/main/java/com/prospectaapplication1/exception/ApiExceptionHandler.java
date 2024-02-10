package com.prospectaapplication1.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<String> handleApiException(ApiException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyExceptionClass> myException(Exception ex, WebRequest web) {
		MyExceptionClass mec = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyExceptionClass> myException(NoHandlerFoundException ex, WebRequest web) {
		MyExceptionClass mec = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyExceptionClass> myException(MethodArgumentNotValidException ex, WebRequest web) {
		MyExceptionClass mec = new MyExceptionClass("Valiation Failed", web.getDescription(false), LocalDateTime.now());
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		List<String> errorsToStringList = MethodArgumentNotValidException.errorsToStringList(allErrors);

		String str = String.join(",", errorsToStringList);

		mec.setDescription(str);

		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.BAD_REQUEST);
	}
}
