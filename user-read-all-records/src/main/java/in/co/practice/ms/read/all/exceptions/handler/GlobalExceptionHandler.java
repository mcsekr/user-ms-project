package in.co.practice.ms.read.all.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.co.practice.ms.read.all.exceptions.DuplicateEmployeePresent;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ DuplicateEmployeePresent.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleBadRequests(Exception e) {
		Map<String, String> error = new HashMap<String, String>();
		error.put("message", e.getMessage());
		return ResponseEntity.badRequest().body(error);
	}
	

}
