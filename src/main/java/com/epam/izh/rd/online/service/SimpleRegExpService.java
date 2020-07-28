package com.epam.izh.rd.online.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleRegExpService implements RegExpService {

    @Override
    public String maskSensitiveData() throws IOException {
        return new BufferedReader(new FileReader("src/main/resources/sensitive_data.txt")).readLine().
                replaceAll("(?<=\\d{4}\\s)(\\d{4}\\s){2}(?=\\d{4})", "**** **** ");
    }

    @Override
    public String replacePlaceholders(double paymentAmount, double balance) throws IOException {
        return new BufferedReader(new FileReader("src/main/resources/sensitive_data.txt")).readLine().
                replaceFirst("\\$\\{\\w+}", String.format("%.0f", paymentAmount)).
                replaceFirst("\\$\\{\\w+}", String.format("%.0f", balance));
    }
}
