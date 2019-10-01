package com.apsidepoei.projetpoei.controllers.restcontrollers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.entities.Person;

import lombok.Data;

/**
 * Res controller.
 * @author clement
 *
 */
@RestController
@RequestMapping("/api/persons")
public class PersonRestController extends BaseRestController<Person, Integer> {

  public PersonRestController(@Autowired PersonRepository repository) {
    super(repository);
  }

  @GetMapping("filtered")
  public Page<Person> getAllFiltered(
      final Pageable pageable,
      @RequestParam(defaultValue = "") final String lastname,
      @RequestParam(defaultValue = "") final String firstname,
      @RequestParam(defaultValue = "") final String email,
      @RequestParam(defaultValue = "") final String cellPhone,
      @RequestParam(defaultValue = "") final String homePhone) {
    return this.getRepository().findAll(pageable, lastname, firstname, email, cellPhone, homePhone);

  }

  @GetMapping("/autocomplete")
  public Page<Person> getForAutocomplete(
      Pageable pageable,
      @Valid TotoVeut1Gato dto) {
    return getRepository().findByAutocomplete(pageable, dto.getTypes(), dto.getValue());
  }

  protected PersonRepository getRepository() {
    return (PersonRepository) this.repository;
  }

  @Data
  public static class TotoVeut1Gato {
    @NotBlank
    private String value;

    @NotEmpty
    @Size(min = 1, max = 3)
    private List<String> types;
  }
}
