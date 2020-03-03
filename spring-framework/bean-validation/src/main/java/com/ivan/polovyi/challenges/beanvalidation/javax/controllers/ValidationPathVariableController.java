package com.ivan.polovyi.challenges.beanvalidation.javax.controllers;

import com.ivan.polovyi.challenges.beanvalidation.javax.dtos.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/validate-path-variable")
@Validated
public class ValidationPathVariableController {

    @GetMapping("/{id}/{name}")
    public ResponseEntity<String> validatePathVariable(
            @PathVariable("id")
            @Min(value = 5,
                    message = "${validatedValue} is invalid has to be more than {value}")
            @Max(value = 10,
                    message = "${validatedValue} is invalid has to be less than {value}")
                    int id,
            @PathVariable("name")
            @Size(min = 1, max = 10, message = "${validatedValue} is invalid has to be between {min} and {max} characters")
                    String name) {
        return ResponseEntity.ok("valid");
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<List<ErrorResponseDTO>> exceptionHandler(ConstraintViolationException e) {
        List<ErrorResponseDTO> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(violation -> errors.add(new ErrorResponseDTO(violation.getPropertyPath()
                + " : " + violation.getMessage())));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
