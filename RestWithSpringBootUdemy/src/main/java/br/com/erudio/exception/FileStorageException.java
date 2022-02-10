package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Edilson
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FileStorageException extends RuntimeException {

	private static final long serialVersionUID = -5810129984163382687L;

	/**
	 * 
	 * @param exceptionMessage
	 */
	public FileStorageException (String exceptionMessage) {
		super(exceptionMessage);
	}
	
	public FileStorageException (String exceptionMessage, Throwable cause) {
		super(exceptionMessage, cause);
	}
}
