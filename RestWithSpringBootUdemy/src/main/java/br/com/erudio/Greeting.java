package br.com.erudio;

/**
 * 
 * @author Edilson
 *
 */
public class Greeting {

	private final long id;
	private final String content;
	
	/**
	 * 	
	 * @param id
	 * @param content
	 */
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}
}
