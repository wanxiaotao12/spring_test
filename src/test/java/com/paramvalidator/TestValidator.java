package com.paramvalidator;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by hongming on 2015/8/5.
 */
public class TestValidator {

    @Test
    public void test(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Person person = new Person();

        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate(person);


        System.out.println(constraintViolations.size());
        System.out.println(constraintViolations.iterator().next().getMessage());
    }
}
