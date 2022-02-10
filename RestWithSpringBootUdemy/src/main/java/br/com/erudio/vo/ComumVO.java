package br.com.erudio.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

/**
 * 
 * @author Edilson
 *
 */
public abstract class ComumVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = -6400000037145260489L;

	/**
	 * 
	 * @return
	 */
	public abstract long getKey();
}
