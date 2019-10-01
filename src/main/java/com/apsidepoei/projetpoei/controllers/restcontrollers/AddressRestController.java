package com.apsidepoei.projetpoei.controllers.restcontrollers;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.AddressRepository;
import com.apsidepoei.projetpoei.entities.Address;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/addresses")
@Api(tags = "Adresses")
public class AddressRestController extends BaseRestController<Address, Integer> {
  public AddressRestController(@Autowired AddressRepository repository) {
    super(repository);
  }
}
