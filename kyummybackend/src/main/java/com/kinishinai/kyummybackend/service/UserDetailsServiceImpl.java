package com.kinishinai.kyummybackend.service;

import java.util.Collection;
import java.util.Optional;
import static java.util.Collections.singletonList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kinishinai.kyummybackend.model.User;
import com.kinishinai.kyummybackend.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	private final UserRepository userRepository;

		    @Override
		    @Transactional(readOnly = true)
		    public UserDetails loadUserByUsername(String email) {
		        Optional<User> userOptional = userRepository.findByEmail(email);
		        User user = userOptional
		                .orElseThrow(() -> new UsernameNotFoundException("No user " +
		                        "Found with username : " + email));

		        return new org.springframework.security
		                .core.userdetails.User(user.getEmail(), user.getPassword(),
		                user.isVerified(), true, true,
		                true, getAuthorities("USER"));
		    }

		    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		        return singletonList(new SimpleGrantedAuthority(role));
	}
	
}
