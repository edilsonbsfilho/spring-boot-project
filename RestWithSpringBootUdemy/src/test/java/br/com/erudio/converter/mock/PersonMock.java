package br.com.erudio.converter.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.model.Person;
import br.com.erudio.vo.PersonVO;

/**
 * 
 * @author Edilson
 *
 */
public class PersonMock {

	/**
	 * 
	 * @return
	 */
	public PersonVO mockVO() {
		return mockVO(0);
	}
	
	/**
	 * 
	 * @return
	 */
	public Person mockEntity() {
		return mockEntity(0);
	}

	/**
	 * 
	 * @return
	 */
	public List<PersonVO> mockListPersonVO() {
		List<PersonVO> personVOList = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			personVOList.add(mockVO(i));
		}
		return personVOList;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Person> mockListPersonEntity() {
		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			personList.add(mockEntity(i));
		}
		return personList;
	}
	
	private PersonVO mockVO(Integer i) {
		PersonVO vo = new PersonVO();
		vo.setFirstName("firstName" + i);
		vo.setLastName("lastName" + i);
		vo.setAddress("address" + i);
		vo.setGender("gender" + i);
		vo.setKey(i.longValue());
		
		return vo;
	}
	
	private Person mockEntity(Integer i) {
		Person entity = new Person();
		entity.setFirstName("firstName" + i);
		entity.setLastName("lastName" + i);
		entity.setAddress("address" + i);
		entity.setGender("gender" + i);
		entity.setId(i.longValue());
		
		return entity;
	}
}
