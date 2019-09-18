package com.apsidepoei.projetpoei.configurations.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

  @GetMapping("/deconnexion")
  public String logout() {
    return "logout";
  }

}
