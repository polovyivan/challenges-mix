package com.ivan.polovyi.challenges.beanvalidation.javax;

import com.ivan.polovyi.challenges.beanvalidation.javax.dtos.ValidationJavaxDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

import javax.validation.constraints.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/messages.properties")
public class ValidationJavaxTest {

    private static final String PATH = "/validation";
    private static final String REJECTED_VALUE = "rejectedValue";

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Value("${app.constraints.decimal-max.message}")
    private String decimalMaxMess;

    @Value("${app.constraints.decimal-min.message}")
    private String decimalMinMess;

    @Value("${app.constraints.digits.message}")
    private String digitMess;

    @Value("${app.constraints.max.message}")
    private String maxMess;

    @Value("${app.constraints.min.message}")
    private String minMess;

    @Value("${app.constraints.negative.message}")
    private String negativeMess;

    @Value("${app.constraints.negative-or-zero.message}")
    private String negativeOrZeroMess;

    @Value("${app.constraints.positive.message}")
    private String positiveMess;

    @Value("${app.constraints.positive-or-zero.message}")
    private String positiveOrZeroMess;

    @Value("${app.constraints.not-blank.message}")
    private String notBlankMess;

    @Value("${app.constraints.not-empty.message}")
    private String notEmptyMess;

    @Value("${app.constraints.not-null.message}")
    private String notNullMess;

    @Value("${app.constraints.null.message}")
    private String nullMess;

    @Value("${app.constraints.pattern.message}")
    private String patternMess;

    @Value("${app.constraints.size.message}")
    private String sizeMess;

    @Value("${app.constraints.e-mail.message}")
    private String emailMess;

    @Value("${app.constraints.future.message}")
    private String futureMess;

    @Value("${app.constraints.future-or-present.message}")
    private String futureOrPresentMess;

    @Value("${app.constraints.past.message}")
    private String pastMess;

    @Value("${app.constraints.past-or-present.message}")
    private String pastOrPresentMess;


    private static ValidationJavaxDTO validationJavaxDTO;


    @Test
    public void testConstrainsDecimalMax() {

        validationJavaxDTO = ValidationJavaxDTO.create();
        // error max limit set to 12.00
        BigDecimal decimalMax = new BigDecimal("12.01");
        validationJavaxDTO.setDecimalMax(decimalMax);

        String responseBody = getResponseBody();

        assertEquals(1, getErrorMessageCount(responseBody));

        Function<Field, String> fieldStringFunction = f -> f.getAnnotation(DecimalMax.class).value();
        String fieldName = "decimalMax";
        String decimalMaxValue = getAttribute(fieldStringFunction, fieldName);
        assertTrue(responseBody.contains(decimalMax + " " + decimalMaxMess + " " + decimalMaxValue));

        //success
        validationJavaxDTO.setDecimalMax(new BigDecimal("11.99"));

        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsDecimalMin() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        // error min limit set to 0.225
        BigDecimal decimalMin = new BigDecimal("0.01");
        validationJavaxDTO.setDecimalMin(decimalMin);
        String responseBody = getResponseBody();

        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(decimalMinMess));


        Function<Field, String> fieldStringFunction = f -> f.getAnnotation(DecimalMin.class).value();
        String fieldName = "decimalMin";
        String decimalMinValue = getAttribute(fieldStringFunction, fieldName);

        assertTrue(responseBody.contains(decimalMin + " " + decimalMinMess + " " + decimalMinValue));

        //success
        validationJavaxDTO.setDecimalMin(new BigDecimal("11.99"));

        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsDigits() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        // error integer = 3, fraction = 2,
        BigDecimal digits = new BigDecimal("1.1214");
        validationJavaxDTO.setDigits(digits);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(digitMess));

        Function<Field, String> fieldIntegerFunction = f -> String.valueOf(f.getAnnotation(Digits.class).integer());
        Function<Field, String> fieldFractionFunction = f -> String.valueOf(f.getAnnotation(Digits.class).fraction());
        String fieldName = "digits";
        String digitsInteger = getAttribute(fieldIntegerFunction, fieldName);
        String digitsFraction = getAttribute(fieldFractionFunction, fieldName);

        assertTrue(responseBody.contains(digits + " " + digitMess + " " + digitsInteger + ", " + digitsFraction));


        //success
        validationJavaxDTO.setDigits(new BigDecimal("333.22"));
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsMax() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        // error max = 10
        int maxValueSet = 11;
        validationJavaxDTO.setMaxValue(maxValueSet);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));

        Function<Field, String> fieldStringFunction = f -> String.valueOf(f.getAnnotation(Max.class).value());
        String fieldName = "maxValue";
        String maxValue = getAttribute(fieldStringFunction, fieldName);

        assertTrue(responseBody.contains(maxValueSet + " " + maxMess + " " + maxValue));


        //success
        validationJavaxDTO.setMaxValue(10);
        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsMin() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        // error min = 1
        int minValueSet = 0;
        validationJavaxDTO.setMinValue(minValueSet);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        Function<Field, String> fieldStringFunction = f -> String.valueOf(f.getAnnotation(Min.class).value());
        String fieldName = "minValue";
        String minValue = getAttribute(fieldStringFunction, fieldName);

        assertTrue(responseBody.contains(minValueSet + " " + minMess + " " + minValue));


        //success
        validationJavaxDTO.setMinValue(10);
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsNegative() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        int negativeValue = 0;
        validationJavaxDTO.setNegativeValue(negativeValue);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(negativeValue + " " + negativeMess));

        //success
        validationJavaxDTO.setNegativeValue(-10);
        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsNegativeOrZero() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        int negativeOrZero = 100;
        validationJavaxDTO.setNegativeOrZero(negativeOrZero);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(negativeOrZero + " " + negativeOrZeroMess));

        //success
        validationJavaxDTO.setNegativeOrZero(0);
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsPositive() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        int positive = -100;
        validationJavaxDTO.setPositive(positive);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(positive + " " + positiveMess));

        //success (0 doesn't work)
        validationJavaxDTO.setPositive(1);
        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsPositiveOrZero() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        int positiveOrZero = -10;
        validationJavaxDTO.setPositiveOrZero(positiveOrZero);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(positiveOrZero + " " + positiveOrZeroMess));

        //success
        validationJavaxDTO.setPositiveOrZero(0);
        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsFuture() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        LocalDateTime future = LocalDateTime.now().minusDays(1);
        validationJavaxDTO.setFuture(future);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(future + " " + futureMess));

        //success
        validationJavaxDTO.setFuture(LocalDateTime.now().plusDays(5));
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsFutureOrPresent() {
        validationJavaxDTO = ValidationJavaxDTO.create();

        LocalDateTime futureOrPresent = LocalDateTime.now().minusDays(1);
        validationJavaxDTO.setFutureOrPresent(futureOrPresent);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(futureOrPresent + " " + futureOrPresentMess));

        //success
        validationJavaxDTO.setFutureOrPresent(LocalDateTime.now().plusSeconds(10));
        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsPast() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        LocalDateTime past = LocalDateTime.now().plusSeconds(100);
        validationJavaxDTO.setPast(past);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(past + " " + pastMess));

        //success
        validationJavaxDTO.setPast(LocalDateTime.now().minusSeconds(10));
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsPastOrPresent() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        LocalDateTime pastOrPresent = LocalDateTime.now().plusSeconds(100);
        validationJavaxDTO.setPastOrPresent(pastOrPresent);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(pastOrPresent + " " + pastOrPresentMess));

        //success
        validationJavaxDTO.setPastOrPresent(LocalDateTime.now().minusSeconds(10));
        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsSize() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        // max 25, min 2
        String valuePassed = "1";
        validationJavaxDTO.setSize(valuePassed);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));


        Function<Field, String> fieldSizeMinFunction = f -> String.valueOf(f.getAnnotation(Size.class).min());
        String fieldName = "size";
        Function<Field, String> fieldStringMaxFunction = f -> String.valueOf(f.getAnnotation(Size.class).max());

        String sizeValueMax = getAttribute(fieldStringMaxFunction, fieldName);
        String sizeValueMin = getAttribute(fieldSizeMinFunction, fieldName);

        assertTrue(responseBody.contains(valuePassed + " " + sizeMess + " " + sizeValueMin + " " + sizeValueMax));

        valuePassed = "123456789101112131415161718";
        validationJavaxDTO.setSize(valuePassed);

        responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));

        assertTrue(responseBody.contains(valuePassed + " " + sizeMess + " " + sizeValueMin + " " + sizeValueMax));


        //success
        validationJavaxDTO.setSize("ivan");
        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsPattern() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        // pattern of SSN
        String notAPattern = "not a pattern";
        validationJavaxDTO.setPattern(notAPattern);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(notAPattern + " " + patternMess));

        //success
        validationJavaxDTO.setPattern("111-11-1111");
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsNull() {
        validationJavaxDTO = ValidationJavaxDTO.create();

        validationJavaxDTO.setNullValue("not null");

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(nullMess));

        //success
        validationJavaxDTO.setNullValue(null);
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsNotNull() {
        // @NotNull: The CharSequence, Collection, Map or Array object is not null, but can be empty.
        //STRING
        validationJavaxDTO = ValidationJavaxDTO.create();

        validationJavaxDTO.setNotNull(null);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(notNullMess));

        //success
        validationJavaxDTO.setNotNull("null");
        assertNull(getResponseBody());

        // MAP
        validationJavaxDTO.setNotNullMap(null);

        responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(notNullMess));

        //success
        validationJavaxDTO.setNotNullMap(new HashMap<>());
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsNotEmpty() {

        // @NotEmpty: The CharSequence, Collection, Map or Array object is not null and size > 0.
        validationJavaxDTO = ValidationJavaxDTO.create();

        validationJavaxDTO.setNotEmpty(null);

        String responseBody = getResponseBody();

        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(" " + notEmptyMess));

        //success
        validationJavaxDTO.setNotEmpty("null");
        assertNull(getResponseBody());
    }

    @Test
    public void testConstrainsNotBlank() {

        // @NotBlank: The string is not null and the trimmed length is greater than zero.
        validationJavaxDTO = ValidationJavaxDTO.create();

        // null check
        validationJavaxDTO.setNotBlank(null);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(" " + notBlankMess));

        // length check
        String testValue = " ";
        validationJavaxDTO.setNotBlank(testValue);

        responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(testValue + " " + notBlankMess));


        //success
        validationJavaxDTO.setNotBlank(" 1");
        assertNull(getResponseBody());
    }


    @Test
    public void testConstrainsEmail() {
        validationJavaxDTO = ValidationJavaxDTO.create();
        // error
        String notAnEmail = "not an email";
        validationJavaxDTO.setEmail(notAnEmail);

        String responseBody = getResponseBody();
        assertEquals(1, getErrorMessageCount(responseBody));
        assertTrue(responseBody.contains(notAnEmail + " " + emailMess));

        //success
        validationJavaxDTO.setEmail("polovyiivan@gmail.com");
        assertNull(getResponseBody());
    }

    private String getResponseBody() {
        return testRestTemplate
                .postForEntity(PATH, validationJavaxDTO, String.class)
                .getBody();
    }


    private long getErrorMessageCount(String body) {
        return Pattern.compile("\\b" + REJECTED_VALUE)
                .splitAsStream(body)
                .count() - 1;
    }


    private String getAttribute(Function<Field, String> fieldStringFunction, String fieldName) {
        return Arrays.stream(ValidationJavaxDTO.class.getDeclaredFields())
                .filter(f -> f.getName().equals(fieldName))
                .map(fieldStringFunction)
                .reduce(Objects::toString).get();
    }

}
