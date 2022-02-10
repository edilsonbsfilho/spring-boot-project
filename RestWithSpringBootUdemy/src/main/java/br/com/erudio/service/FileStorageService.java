package br.com.erudio.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.erudio.config.FileStorageConfig;
import br.com.erudio.exception.FileStorageException;
import br.com.erudio.exception.MyFileNotFoundException;

/**
 * 
 * @author Edilson
 *
 */
@Service
public class FileStorageService {

	private final Path fileStorageLocation;
	
	/**
	 * 
	 * @param fileStorageConfig
	 */
	@Autowired
	public FileStorageService(FileStorageConfig fileStorageConfig) {
		this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (IOException e) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be storage.", e);
		}
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			validateFile(fileName);
			
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			return fileName;
		} catch (Exception e) {
			throw new FileStorageException("Could not store file" + fileName + ". Please try again.", e);
		}
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File " + fileName + "not found.");
			}
		} catch (Exception e) {
			throw new MyFileNotFoundException("File " + fileName + "not found.", e);
		}
	}
	
	private void validateFile(String fileName) {
		if (fileName.contains("..")) {
			throw new FileStorageException("Filename contains invalid path. " + fileName);
		}
	}
}
