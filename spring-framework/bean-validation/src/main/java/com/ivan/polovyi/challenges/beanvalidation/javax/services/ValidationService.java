package com.ivan.polovyi.challenges.beanvalidation.javax.services;

import com.ivan.polovyi.challenges.beanvalidation.javax.dtos.ValidationJavaxDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationService {
    private List<ValidationJavaxDTO> javaxDTOS = new ArrayList<>();

    public void addJavaxDto(ValidationJavaxDTO validationJavaxDTO) {

        javaxDTOS.add(validationJavaxDTO);
    }

    public List<ValidationJavaxDTO> getJavaxDTOS() {

        if (javaxDTOS.size() == 0) {
            this.addJavaxDto(ValidationJavaxDTO.create());
        }
        return javaxDTOS;
    }


    public ValidationJavaxDTO getJavaxDTOS(String id) {

        if (javaxDTOS.size() == 0) {
            this.addJavaxDto(ValidationJavaxDTO.create());
        }
        return javaxDTOS.stream().filter(dto -> dto.getDigits().equals(id))
                .findFirst()
                .orElse(ValidationJavaxDTO.create());
    }
}
