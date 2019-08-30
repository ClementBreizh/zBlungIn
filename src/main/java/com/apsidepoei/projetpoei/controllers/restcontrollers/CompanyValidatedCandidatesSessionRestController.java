/**
*
*/
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.CompanyValidatedCandidatesSessionRepository;

/**
* @author vianney
*
*/
@RestController
@RequestMapping("/api/valCandidBySessionAndCompany")
public class CompanyValidatedCandidatesSessionRestController {
 public CompanyValidatedCandidatesSessionRestController(@Autowired CompanyValidatedCandidatesSessionRepository repository) {
   super();
 }
}
