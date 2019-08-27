/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.AddressRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/addresses")
public class AddressRestController {
  public AddressRestController(@Autowired AddressRepository repository) {
    super();
  }
}
