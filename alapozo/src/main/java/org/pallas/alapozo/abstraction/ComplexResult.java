package org.pallas.alapozo.abstraction;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;

public class ComplexResult<T> {
	public T Object;
	public HttpStatus Status;
	public String Message;

	public ComplexResult() {
		
	}
	public ComplexResult(T object, String message, HttpStatus status) {
		Object = object;
		Message = message;
		Status = status;
	}
}
