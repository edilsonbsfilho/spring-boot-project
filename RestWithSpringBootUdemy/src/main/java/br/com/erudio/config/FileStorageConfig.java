package br.com.erudio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author Edilson
 *
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageConfig {

	private String uploadDir;

	/**
	 * 
	 * @return
	 */
	public String getUploadDir() {
		return uploadDir;
	}

	/**
	 * 
	 * @param uploadDir
	 */
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}
