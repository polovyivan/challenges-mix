package com.ivan.polovyi.challenges.beanvalidation.javax.controllers;

import com.ivan.polovyi.challenges.beanvalidation.javax.dtos.ValidationJavaxDTO;
import com.ivan.polovyi.challenges.beanvalidation.javax.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/validation")
@Validated
public class ValidationController {


    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity<Void> validate(@Validated @RequestBody ValidationJavaxDTO validationDTO) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ValidationJavaxDTO>> getDTO() {

        return new ResponseEntity<>(validationService.getJavaxDTOS(), HttpStatus.OK);
    }



    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<List<String>> exceptionHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(violation -> errors.add(violation.getPropertyPath()
                + " : " + violation.getMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
