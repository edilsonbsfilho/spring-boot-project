package br.com.erudio.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * 
 * @author Edilson
 *
 */
public class DozerConverter {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	/**
	 * 
	 * @param <O> type of origin object
	 * @param <D> type of destiny object
	 * @param objectOrigin
	 * @param destinationClass
	 * @return
	 */
	public static <O,D> D parseObject(O objectOrigin, Class<D> destinationClass) {
		return mapper.map(objectOrigin, destinationClass);
	}
	
	/**
	 * 
	 * @param <O> type of origin object
	 * @param <D> type of destiny object
	 * @param listObjectsOrigin
	 * @param destinationClass
	 * @return
	 */
	public static <O,D> List<D> parseListObjects(List<O> listObjectsOrigin, Class<D> destinationClass) {
		List<D> destinationObjects = new ArrayList<>();
		
		for (Object objectOrigin : listObjectsOrigin) {
			destinationObjects.add(mapper.map(objectOrigin, destinationClass));
		}
		
		return destinationObjects; 
	}
}
