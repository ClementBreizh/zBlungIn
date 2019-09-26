package com.apsidepoei.projetpoei.securityservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apsidepoei.projetpoei.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserServiceImpl userServiceImpl;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userServiceImpl.findByLogin(username);

    if (user == null) {
      return null;
    }

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    if (user.getRole() != null) {
      grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));

    }
    UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
    userBuilder.username(user.getLogin());
    userBuilder.password(user.getPassword());
    userBuilder.authorities(grantedAuthorities);

    return userBuilder.build();
  }
}
