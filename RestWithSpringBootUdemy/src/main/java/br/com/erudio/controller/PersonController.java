package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.service.PersonService;
import br.com.erudio.vo.PersonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Edilson
 *
 */
//@CrossOrigin
@Api(value = "Person Services", description = "EndPoints for Person manipulation", tags = {"Person Services"})
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

	@Autowired
	private PersonService  personService;
	
	@Autowired
	private PagedResourcesAssembler<PersonVO> assembler;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO personVO = personService.findById(id);
		personVO.add(
				linkTo(
						methodOn(PersonController.class)
						.findById(id))
				.withSelfRel());
		return personVO;
	}
	
	/** 
	 *  
	 * @return
	 */
	@ApiOperation(value = "Find all people recorded")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
								  @RequestParam(value = "size", defaultValue = "10") int sizePage,
								  @RequestParam(value = "sort", defaultValue = "firstName,asc") String sort) {
		
		Pageable pageable = PageRequest.of(page, sizePage, getSort(sort));
		
		Page<PersonVO> pagePersons = personService.findAll(pageable);
		pagePersons
			.stream()
			.forEach(p -> addHateoas(p));
		
		return new ResponseEntity<>(assembler.toResource(pagePersons), HttpStatus.OK);
	}	
	
	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "Find persons by name")
	@GetMapping(value = "/findByName/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findByName(@PathVariable("name") String name,
								  @RequestParam(value = "page", defaultValue = "0") int page,
								  @RequestParam(value = "size", defaultValue = "10") int sizePage,
								  @RequestParam(value = "sort", defaultValue = "firstName,asc") String sort) {
		
		Pageable pageable = PageRequest.of(page, sizePage, getSort(sort));
		
		Page<PersonVO> pagePersons = personService.findByName(name, pageable);
		pagePersons
			.stream()
			.forEach(p -> addHateoas(p));
		
		return new ResponseEntity<>(assembler.toResource(pagePersons), HttpStatus.OK);
	}

	/**
	 * 
	 * @param person
	 * @return
	 */
	//@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO create(@RequestBody PersonVO person) {
		return personService.create(person);
	}
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO update(@RequestBody PersonVO person) {
		return personService.update(person);
	}
	
	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@PatchMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO disablePerson(@PathVariable("id") Long id) {
		PersonVO personVO = personService.disablePerson(id);
		personVO.add(
				linkTo(
						methodOn(PersonController.class)
						.findById(id))
				.withSelfRel());
		return personVO;
	}
	
	private Sort getSort(String sort) {
		Direction dir = Direction.ASC;
		String sorts[] = sort.split(",");
		String field = sorts[0];
		String direction = sorts[1];
		
		if (direction.equalsIgnoreCase("desc")) {
			dir = Direction.DESC;
		}		
		
		return Sort.by(dir, field);
	}
	
	private void addHateoas(PersonVO personVO) {
		Long id = personVO.getKey();
		personVO.add(
				linkTo(
						methodOn(PersonController.class)
						.findById(id))
				.withSelfRel());
	}
}
