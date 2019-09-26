package com.apsidepoei.projetpoei.configurations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;


public class CustomLogoutHandler implements LogoutHandler {

  @Autowired
  private AuthenticationManager managerAuth;

  @Override
  public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    if (authentication != null) {
      authentication.setAuthenticated(false);
    }

   managerAuth.authenticate(authentication);
  }

}
