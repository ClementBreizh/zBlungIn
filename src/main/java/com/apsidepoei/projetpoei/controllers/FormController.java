/**
 *
 */
package com.apsidepoei.projetpoei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author vianney
 *
 */

@Controller
public class FormController {

  @GetMapping("/index")
  public String getIndex() {
    return "/index";
  }

  @GetMapping("/index2")
  public String getIndex2(){
    return "/index2";
  }
}
