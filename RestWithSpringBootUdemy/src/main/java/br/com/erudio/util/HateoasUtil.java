package br.com.erudio.util;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import br.com.erudio.controller.AbstractController;
import br.com.erudio.vo.ComumVO;

/**
 * 
 * @author Edilson
 *
 */
public class HateoasUtil {

	/**
	 * Adiciona hateoas aos objetos da lista 
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T extends ComumVO, K extends AbstractController> List<T> addHateoas(List<T> list, Class<K> controllerClass) {
		for (T obj : list) {
			addHateoasVO(obj, controllerClass);
		}
		return list;
	}

	/**
	 * Adiciona hateoas ao objeto
	 * @param <T>
	 * @param obj
	 */
	public static <T extends ComumVO, K extends AbstractController> void addHateoasVO(T obj, Class<K> controllerClass) {
		long id = obj.getKey();
		
		obj.add(
				linkTo(
						((K) methodOn(controllerClass)).findById(id))
				.withSelfRel());
	}
}
