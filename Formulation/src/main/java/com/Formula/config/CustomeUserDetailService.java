package com.Formula.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Formula.Entity.UserRequest;
import com.Formula.Repo.UserRepo;

@Service
public class CustomeUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserRequest user = userRepo.findByEmail(username);

		if (user == null) { // if user email is not present in database

			throw new UsernameNotFoundException("Invalid Credentials");
		} else {
			return new CustomUser(user); // CustomUser made in other class as UserDetails is interface we can no return
		}

	}

}
