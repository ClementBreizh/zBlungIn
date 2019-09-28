package com.apsidepoei.projetpoei.controllers.restcontrollers;

import com.apsidepoei.projetpoei.database.repositories.DegreeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 * @author vianney.
 *
 */
@RestController
@RequestMapping("/api/degrees/dto")
public class DegreeRestControllerDto {

  @Autowired
  private DegreeRepository repository;

  public DegreeRestControllerDto() {

  }

//  @GetMapping(value= {"","/","/index"})
//  public List<DegreeDto> getAll() {
//    List<DegreeDto> result = new ArrayList();
//    for (Degree iterable_element : repository.findAll()) {
//      DegreeDto dto = new DegreeDto();
//      dto.parseIn(iterable_element);
//      result.add(dto);
//    }
//    return result;
//  }
}
