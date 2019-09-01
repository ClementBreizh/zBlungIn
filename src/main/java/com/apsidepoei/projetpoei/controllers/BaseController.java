package com.apsidepoei.projetpoei.controllers;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Generic controller for all entities.
 * @author thomas
 *
 */
public abstract class BaseController {
  private String path;

  /**
   * Constructeur.
   * @param entityPath = the path variable from child controller.
   */
  public BaseController(String entityPath) {
    path = entityPath;
  }

  /**
   * Generic mapping method.
   * @return
   */
  @GetMapping(path= "/index")
  public String getIndex() {
    return path + "/index";
  }
}
