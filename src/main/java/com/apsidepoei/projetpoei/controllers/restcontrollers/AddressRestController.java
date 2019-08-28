/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AddressRepository;
import com.apsidepoei.projetpoei.entities.Address;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/addresses")
public class AddressRestController extends BaseRestController<Address, Integer> {
  public AddressRestController(@Autowired AddressRepository repository) {
    super(repository);
  }
}
