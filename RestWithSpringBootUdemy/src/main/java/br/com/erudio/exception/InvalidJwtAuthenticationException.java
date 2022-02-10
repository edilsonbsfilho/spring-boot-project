package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Edilson
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = -8855528944531302871L;

	/**
	 * 
	 * @param exceptionMessage
	 */
	public InvalidJwtAuthenticationException (String exceptionMessage) {
		super(exceptionMessage);
	}
}
