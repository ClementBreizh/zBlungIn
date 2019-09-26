package com.apsidepoei.projetpoei.securityservice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.apsidepoei.projetpoei.database.repositories.UserRepository;
import com.apsidepoei.projetpoei.entities.User;

@Service
@Validated
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;


  @Override
  public User save(@Valid User user) {
    String idForEncode = "bcrypt";
    Map<String, PasswordEncoder> encoders = new HashMap<String, PasswordEncoder>();
    encoders.put(idForEncode, new BCryptPasswordEncoder());

    PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
    user.setPassword(passwordEncoder.encode(user.getNoEncodedPassword()));
    return userRepository.save(user);
  }

  @Override
  public User findByLogin(String login) {
    return userRepository.findByLogin(login);
  }
}
