package com.apsidepoei.projetpoei.configurations.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("paramUsername", "login");
    model.addAttribute("paramPassword", "pwd");
    return "login";
  }

}
