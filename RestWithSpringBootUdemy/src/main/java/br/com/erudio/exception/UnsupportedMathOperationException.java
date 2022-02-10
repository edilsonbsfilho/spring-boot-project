package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Edilson
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

	private static final long serialVersionUID = -3924395697786151751L;
	
	/**
	 * 
	 * @param exceptionMessage
	 */
	public UnsupportedMathOperationException (String exceptionMessage) {
		super(exceptionMessage);
	}
}
