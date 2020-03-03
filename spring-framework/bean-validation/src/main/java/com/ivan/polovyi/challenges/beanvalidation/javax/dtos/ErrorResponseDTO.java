package com.ivan.polovyi.challenges.beanvalidation.javax.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private String errorMessage;
}
