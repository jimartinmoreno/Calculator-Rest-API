package com.sanitas.calculator.service;

import com.sanitas.calculator.domain.Request;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    void sum() {
        int result = calculatorService.sum(new Request(1, 1));
        assertThat(result).isEqualTo(2);
    }


    @Test
    void subtraction() {
        int result = calculatorService.subtraction(new Request(1, 1));
        assertThat(result).isZero();
    }
}