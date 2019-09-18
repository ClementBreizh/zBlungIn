package com.apsidepoei.projetpoei.securityservice;

import javax.validation.Valid;

import com.apsidepoei.projetpoei.entities.User;

public interface UserService {

  void save(@Valid User user);
  User findByLogin(String login);
}
