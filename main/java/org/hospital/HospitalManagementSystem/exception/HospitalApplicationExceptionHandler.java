package org.hospital.HospitalManagementSystem.exception;

import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HospitalApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(idNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(idNotFoundException exception) {
		ResponseStructure<String> s = new ResponseStructure<String>();
		s.setBody("Hospital not Found");
		s.setMessage(exception.getMessage());
		s.setCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);

	}

}
