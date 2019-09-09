package com.apsidepoei.projetpoei.controllers.restcontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.controllers.restcontrollers.dtos.DegreeDto;
import com.apsidepoei.projetpoei.database.repositories.DegreeRepository;
import com.apsidepoei.projetpoei.entities.Degree;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/degrees/dto")
public class DegreeRestControllerDto{

  @Autowired
  private DegreeRepository repository;
  public DegreeRestControllerDto() {

  }

  @GetMapping(value= {"","/","/index"})
  public List<DegreeDto> getAll() {
    List<DegreeDto> result = new ArrayList();
    for (Degree iterable_element : repository.findAll()) {
      DegreeDto dto = new DegreeDto();
      dto.parseIn(iterable_element);
      result.add(dto);
    }
    return result;
  }
}
