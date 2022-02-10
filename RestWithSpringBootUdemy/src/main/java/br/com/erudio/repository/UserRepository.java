package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.User;

/**
 * 
 * @author Edilson
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * 
	 * @param userName
	 * @return
	 */
	@Query("SELECT u FROM User u WHERE u.userName = :userName")
	User findByUserName(@Param("userName") String userName);
}
