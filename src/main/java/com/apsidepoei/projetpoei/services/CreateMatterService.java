package com.apsidepoei.projetpoei.services;

import com.apsidepoei.projetpoei.database.repositories.AcquiredMattersRepository;
import com.apsidepoei.projetpoei.database.repositories.MatterRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;
import com.apsidepoei.projetpoei.entities.Matter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CreateMatterService {
  
  @NonNull
  private final MatterRepository repository;
  
  @NonNull
  private final AcquiredMattersRepository acquiredMattersRepository;
  
  /** Constructor with service injections. */
  public CreateMatterService(
      @Autowired final MatterRepository repository,
      @Autowired final AcquiredMattersRepository acquiredMattersRepository) {
    super();
    this.repository = repository;
    this.acquiredMattersRepository = acquiredMattersRepository;
  }
  
  /**
   * Fills {@code acquiredMatters} with matter (got from database or just created).
   * @param name The name of matter.
   * @param acquiredMatters The partial {@link AcquiredMatters}.
   * @return
   */
  public AcquiredMatters create(@NonNull final String name, @NonNull final AcquiredMatters acquiredMatters) {
    final Matter matter = this.repository
        .findByName(name)
        .orElseGet(() -> this.createMatter(name));
    
    acquiredMatters.setMatter(matter);
    
    this.acquiredMattersRepository.save(acquiredMatters);
    
    return acquiredMatters;
  }
  
  private final Matter createMatter(@NonNull final String name) {
    final Matter result = new Matter(name);
  
    this.repository.save(result);
  
    return result;
  }
}
