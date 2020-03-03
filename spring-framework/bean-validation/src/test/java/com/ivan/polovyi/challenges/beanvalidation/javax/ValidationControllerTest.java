package com.ivan.polovyi.challenges.beanvalidation.javax;

import com.ivan.polovyi.challenges.beanvalidation.javax.controllers.ValidationPathVariableController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ValidationPathVariableController.class)
class ValidationControllerTest {

    @Autowired
    MockMvc mockMvc;

    private final String PATH = "/validate-path-variable";

    @Test
    void validate() throws Exception {

        String passedId = "4";
        String passedName = "moreTenCharacters";


        mockMvc.perform(get(PATH + "/" + passedId + "/" + passedName)).andExpect(status().isBadRequest())
                .andDo(print())
                .andExpect(jsonPath("$.[0].errorMessage").exists())
                .andExpect(jsonPath("$.[1].errorMessage").exists())
                .andExpect(jsonPath("$.[0].errorMessage")
                        .value("validatePathVariable.name : " + passedName + " is invalid has to be between 1 and 10 characters"))
                .andExpect(jsonPath("$.[1].errorMessage")
                        .value("validatePathVariable.id : " + passedId + " is invalid has to be more than 5"));
    }
}