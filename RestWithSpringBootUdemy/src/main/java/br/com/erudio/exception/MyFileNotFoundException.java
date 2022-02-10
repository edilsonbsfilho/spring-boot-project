package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Edilson
 *
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class MyFileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5810129984163382687L;

	/**
	 * 
	 * @param exceptionMessage
	 */
	public MyFileNotFoundException (String exceptionMessage) {
		super(exceptionMessage);
	}
	
	public MyFileNotFoundException (String exceptionMessage, Throwable cause) {
		super(exceptionMessage, cause);
	}
}
