package com.mx.jorge.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static com.mx.jorge.examen.utils.Constantes.*;

@Service
public class PorpertiesUserDetailService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(!username.equals(USERNAME)) {
			throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema", username));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(username,PASSWORD_ECRYPTADO,true,true,true,true, authorities);
		
	}

}
