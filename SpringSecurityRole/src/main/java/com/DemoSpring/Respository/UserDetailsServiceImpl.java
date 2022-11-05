package com.DemoSpring.Respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.DemoSpring.Model.User;

public class UserDetailsServiceImpl  implements UserDetailsService{

	@Autowired
	private UserRespository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserbyUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Could not find user");
			
		}
		return new MyUserDetails(user);
	}
	
}
