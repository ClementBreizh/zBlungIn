package com.apsidepoei.projetpoei.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;


@Component
public class PasswordValidator implements ConstraintValidator<PasswordValidatorConstraint, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Boolean result = true;

    if (value == null) {
      context.buildConstraintViolationWithTemplate("Cannot be null").addConstraintViolation();
      result = false;
    }

    if (value.length() < 8) {
      context.buildConstraintViolationWithTemplate("Cannot be less than 8 characters").addConstraintViolation();
      result = false;
    }

    if (value.length() > 24) {
      context.buildConstraintViolationWithTemplate("Cannot be more than 24 characters").addConstraintViolation();
      result = false;
    }

    return result;
  }
}
