package br.com.erudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.model.User;
import br.com.erudio.repository.UserRepository;

/**
 * 
 * @author Edilson
 *
 */
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;
	
	/**
	 * 
	 * @param repo
	 */
	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}

	/**
	 * 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUserName(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("User Name " + username + " not found.");
		}
	}
	
	
}
