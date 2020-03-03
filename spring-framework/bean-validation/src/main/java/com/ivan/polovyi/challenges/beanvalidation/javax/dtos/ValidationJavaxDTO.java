package com.ivan.polovyi.challenges.beanvalidation.javax.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class ValidationJavaxDTO {


    @DecimalMax(value = "12.0",
            inclusive = false,
            message = "${validatedValue} {app.constraints.decimal-max.message} {value}")
    private BigDecimal decimalMax;

    @DecimalMin(value = "0.225",
            inclusive = false,
            message = "${validatedValue} {app.constraints.decimal-min.message} {value}")
    private BigDecimal decimalMin;

    @Digits(integer = 3,
            fraction = 2,
            message = "${validatedValue} {app.constraints.digits.message} {integer}, {fraction}")
    private BigDecimal digits;

    @Max(value = 10,
            message = "${validatedValue} {app.constraints.max.message} {value}")
    private int maxValue;

    @Min(value = 1,
            message = "${validatedValue} {app.constraints.min.message} {value}")
    private int minValue;

    @Negative(message = "${validatedValue} {app.constraints.negative.message}")
    private int negativeValue;

    @NegativeOrZero(message = "${validatedValue} {app.constraints.negative-or-zero.message}")
    private int negativeOrZero;

    @Positive(message = "${validatedValue} {app.constraints.positive.message}")
    private int positive;

    @PositiveOrZero(message = "${validatedValue} {app.constraints.positive-or-zero.message}")
    private int positiveOrZero;

    @NotBlank(message = "${validatedValue} {app.constraints.not-blank.message}")
    private String notBlank;

    @NotEmpty(message = "${validatedValue} {app.constraints.not-empty.message}")
    private String notEmpty;

    @NotNull(message = "${validatedValue} {app.constraints.not-null.message}")
    private String notNull;

    @NotNull(message = "${validatedValue} {app.constraints.not-null.message}")
    private Map<Integer, String> notNullMap;

    @Null(message = "${validatedValue} {app.constraints.null.message}")
    private String nullValue;


    @Pattern(regexp = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$",
            message = "${validatedValue} {app.constraints.pattern.message}")
    private String pattern;

    @Size(max = 25,
            min = 2,
            message = "${validatedValue} {app.constraints.size.message} {min} {max}")
    private String size;

    @Email(message = "${validatedValue} {app.constraints.e-mail.message}")
    private String email;

    @Future(message = "${validatedValue} {app.constraints.future.message}")
    private LocalDateTime future;

    @FutureOrPresent(message = "${validatedValue} {app.constraints.future-or-present.message}")
    private LocalDateTime futureOrPresent;

    @Past(message = "${validatedValue} {app.constraints.past.message}")
    private LocalDateTime past;

    @PastOrPresent(message = "${validatedValue} {app.constraints.past-or-present.message}")
    private LocalDateTime pastOrPresent;


    public static ValidationJavaxDTO create() {

        return ValidationJavaxDTO.builder()
                .decimalMax(new BigDecimal("10"))
                .decimalMin(new BigDecimal("10.25"))
                .digits(new BigDecimal("100.12"))
                .maxValue(9)
                .minValue(5)
                .negativeValue(-1)
                .negativeOrZero(0)
                .positive(1)
                .positiveOrZero(0)
                .notBlank("notBlank")
                .notEmpty("notEmpty")
                .notNull("notNull")
                .notNullMap(new HashMap<Integer, String>() {{
                    put(1, "value1");
                    put(2, "value2");
                }})
                .nullValue(null)
                .pattern("123-45-6789")
                .size("ivan")
                .email("polovyiivan@gmail.com")
                .future(LocalDateTime.now().plusDays(1))
                .futureOrPresent(LocalDateTime.now().plusHours(1))
                .past(LocalDateTime.now().minusDays(1))
                .pastOrPresent(LocalDateTime.now())
                .build();
    }
}
