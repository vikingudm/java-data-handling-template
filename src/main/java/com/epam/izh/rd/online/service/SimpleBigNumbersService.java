package com.epam.izh.rd.online.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class SimpleBigNumbersService implements BigNumbersService {

    @Override
    public BigDecimal getPrecisionNumber(int a, int b, int range) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), new MathContext(range));
    }

    @Override
    public BigInteger getPrimaryNumber(int range) {
        int value = 0;
        for (int i = 2; ; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (i != j) {
                        break;
                    } else if (value++ == range) {
                        return BigInteger.valueOf(i);
                    }
                }
            }
        }
    }
}
