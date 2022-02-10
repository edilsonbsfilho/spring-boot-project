package br.com.erudio.controller;

import br.com.erudio.vo.ComumVO;

/**
 * 
 * @author Edilson
 *
 */
public abstract class AbstractController {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public abstract <T extends ComumVO> T findById(Long id);
}
