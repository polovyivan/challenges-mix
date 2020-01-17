package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyFormaterTest {

    @Test
    void currencyFormatter() {
        double input = 12324.134;
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String formatted = formatter.format(input);

        String[] output = {"$" + formatted,
                "Rs." + formatted,
                "￥" + formatted,
                formatted.replaceFirst(",", " ")
                        .replaceFirst("\\.", ",") + " €"};


        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
            System.out.println(CurrencyFormater.currencyFormatter(input)[i]);
        }


        assertEquals(output[0], CurrencyFormater.currencyFormatter(input)[0]);
        assertEquals(output[1], CurrencyFormater.currencyFormatter(input)[1]);
        assertEquals(output[2], CurrencyFormater.currencyFormatter(input)[2]);
        //assertEquals(output[3],CurrencyFormater.currencyFormatter(input)[3]);
    }
}