package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Edilson
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3924395697786151751L;
	
	/**
	 * 
	 * @param exceptionMessage
	 */
	public ResourceNotFoundException (String exceptionMessage) {
		super(exceptionMessage);
	}
}
