/**
 *
 */
package com.apsidepoei.projetpoei.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsidepoei.projetpoei.controllers.restcontrollers.base.BaseRestController;
import com.apsidepoei.projetpoei.database.repositories.FeedbackRepository;
import com.apsidepoei.projetpoei.entities.Feedback;

/**
 * @author vianney
 *
 */
@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackRestController extends BaseRestController<Feedback, Integer> {
  public FeedbackRestController(@Autowired FeedbackRepository repository) {
    super(repository);
  }
}
