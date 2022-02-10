package br.com.erudio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.Person;

/**
 * 
 * @author Edilson
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	/**
	 * 
	 * @param id
	 */
	@Modifying
	@Query("UPDATE Person p SET p.enabled = false WHERE p.id = :id")
	void disablePerson(@Param("id") Long id);
	
	/**
	 * 
	 * @param name
	 * @param pageabled
	 * @return
	 */
	@Query("SELECT p FROM Person p WHERE p.firstName LIKE LOWER(CONCAT('%', :name, '%'))")
	Page<Person> findByName(@Param("name") String name, Pageable pageabled);
}
