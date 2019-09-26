package com.apsidepoei.projetpoei.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
  public NotFoundException() {
  }
  
  public NotFoundException(String s) {
    super(s);
  }
  
  public NotFoundException(String s, Throwable throwable) {
    super(s, throwable);
  }
  
  public NotFoundException(Throwable throwable) {
    super(throwable);
  }
  
  public NotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
    super(s, throwable, b, b1);
  }
}
