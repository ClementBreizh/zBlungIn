package com.apsidepoei.projetpoei.securityservice;

import javax.validation.Valid;

import com.apsidepoei.projetpoei.entities.User;

public interface UserService {

  User save(@Valid User user);
  User findByLogin(String login);
}
