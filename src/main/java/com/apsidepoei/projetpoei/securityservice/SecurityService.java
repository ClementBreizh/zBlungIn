package com.apsidepoei.projetpoei.securityservice;

public interface SecurityService {

  String findLoggedUsername();

  void autologin(String username, String password);
}
