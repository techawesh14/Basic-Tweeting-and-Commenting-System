package com.Alemeno.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.Alemeno.dto.ResponseStructure;

@ControllerAdvice
public class AlemenoExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFound(IdNotFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setBody(e.getMessage());
		structure.setMessage("Record not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}