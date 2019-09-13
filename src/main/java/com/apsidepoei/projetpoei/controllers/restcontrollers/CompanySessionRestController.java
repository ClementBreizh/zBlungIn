/**
*
*/
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.CompanySessionRepository;
import com.apsidepoei.projetpoei.entities.CompanySession;

/**
* @author vianney
*
*/
@RestController
@RequestMapping("/api/companyBySession")

public class CompanySessionRestController extends BaseRestController<CompanySession, Integer>{

 public CompanySessionRestController(@Autowired CompanySessionRepository repository) {
   super(repository);
 }
}
