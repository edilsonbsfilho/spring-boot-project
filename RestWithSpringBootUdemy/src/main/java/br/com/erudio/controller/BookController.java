package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.service.BookService;
import br.com.erudio.util.HateoasUtil;
import br.com.erudio.vo.BookVO;
import br.com.erudio.vo.ComumVO;

/**
 * 
 * @author Edilson
 *
 */
@RestController
@RequestMapping("/api/v1/book")
public class BookController extends AbstractController {

	@Autowired
	BookService service;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public <T extends ComumVO> T findById(@PathVariable("id") Long id) {
		BookVO bookVO = service.findById(id);
		HateoasUtil.addHateoasVO(bookVO, BookController.class);		
		return (T) bookVO;
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<BookVO> findAll() {
		return HateoasUtil.addHateoas(service.findAll(), BookController.class);
	}
	
	/*
	 * private List<BookVO> addHateoas(List<BookVO> books) { for (BookVO bookVO :
	 * books) { addHateoasVO(bookVO); } return books; }
	 * 
	 * private void addHateoasVO(BookVO bookVO) { bookVO.add( linkTo(
	 * methodOn(BookController.class).findById(bookVO.getKey())) .withSelfRel()); }
	 */
}
