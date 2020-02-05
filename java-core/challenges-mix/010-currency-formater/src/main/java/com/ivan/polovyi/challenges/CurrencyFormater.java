package com.ivan.polovyi.challenges;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();


        System.out.println("US: " + currencyFormatter(payment)[0]);
        System.out.println("India: " + currencyFormatter(payment)[1]);
        System.out.println("China: " + currencyFormatter(payment)[2]);
        System.out.println("France: " + currencyFormatter(payment)[3]);

    }

    public static String[] currencyFormatter(double payment) {
        String[] currencies = new String[4];

        currencies[0] = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        Locale indLocale = new Locale("en", "IN");
        currencies[1] = NumberFormat.getCurrencyInstance(indLocale).format(payment);
        currencies[2] = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        currencies[3] = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        return currencies;
    }
}
