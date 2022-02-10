package br.com.erudio.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.erudio.converter.mock.PersonMock;
import br.com.erudio.model.Person;
import br.com.erudio.vo.PersonVO;


/**
 * 
 * @author Edilson
 *
 */
public class DozerConverterTest {

	PersonMock mock;
	
	@Before
	public void setUp() {
		mock = new PersonMock();
	}
	
	@Test
	public void parseEntityToVOTest() {
		PersonVO vo = DozerConverter.parseObject(mock.mockEntity(), PersonVO.class);
		Assert.assertEquals(0L, vo.getKey());
		Assert.assertEquals("firstName0", vo.getFirstName());
		Assert.assertEquals("lastName0", vo.getLastName());
		Assert.assertEquals("address0", vo.getAddress());
		Assert.assertEquals("gender0", vo.getGender());
	}
	
	@Test
	public void parseEntityListToVOListTest() {
		List<PersonVO> voList = DozerConverter.parseListObjects(mock.mockListPersonEntity(), PersonVO.class);
		PersonVO vo = voList.get(0);
		Assert.assertEquals(0L, vo.getKey());
		Assert.assertEquals("firstName0", vo.getFirstName());
		Assert.assertEquals("lastName0", vo.getLastName());
		Assert.assertEquals("address0", vo.getAddress());
		Assert.assertEquals("gender0", vo.getGender());
	}
	
	@Test
	public void parseVOToEntityTest() {
		Person vo = DozerConverter.parseObject(mock.mockVO(), Person.class);
		Assert.assertEquals(0L, vo.getId());
		Assert.assertEquals("firstName0", vo.getFirstName());
		Assert.assertEquals("lastName0", vo.getLastName());
		Assert.assertEquals("address0", vo.getAddress());
		Assert.assertEquals("gender0", vo.getGender());
	}
	
	@Test
	public void parseVOListToEntityListTest() {
		List<Person> voList = DozerConverter.parseListObjects(mock.mockListPersonVO(), Person.class);
		Person vo = voList.get(0);
		Assert.assertEquals(0L, vo.getId());
		Assert.assertEquals("firstName0", vo.getFirstName());
		Assert.assertEquals("lastName0", vo.getLastName());
		Assert.assertEquals("address0", vo.getAddress());
		Assert.assertEquals("gender0", vo.getGender());
	}
}
