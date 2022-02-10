package br.com.erudio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Book;
import br.com.erudio.repository.BookRepository;
import br.com.erudio.vo.BookVO;

/**
 * 
 * @author Edilson
 *
 */
@Service
public class BookService {

	private static final String MSG_NENHUM_LIVRO_ENCONTRADO_PARA_O_IDENTIFICADOR_INFORMADO = "Nenhum livro encontrado para o identificador informado.";
	
	@Autowired
	BookRepository repository;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public BookVO findById(Long id) {
		Book book = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MSG_NENHUM_LIVRO_ENCONTRADO_PARA_O_IDENTIFICADOR_INFORMADO));
		return DozerConverter.parseObject(book, BookVO.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<BookVO> findAll() {
		return DozerConverter.parseListObjects(
				repository.findAll(), BookVO.class);
	}

}
