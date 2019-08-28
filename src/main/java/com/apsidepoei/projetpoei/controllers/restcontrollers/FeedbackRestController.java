/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.database.repositories.FeedbackRepository;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackRestController {
  public FeedbackRestController(@Autowired FeedbackRepository repository) {
    super();
  }
}
