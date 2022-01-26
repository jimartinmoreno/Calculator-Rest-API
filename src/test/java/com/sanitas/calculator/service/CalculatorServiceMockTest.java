package com.sanitas.calculator.service;

import com.sanitas.calculator.domain.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceMockTest {

    @InjectMocks
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

    @Test
    void sum2() {
        int result = calculatorService.sum2(new Request(1, 1)).getSolution();
        assertThat(result).isEqualTo(2);
    }

    @Test
    void subtraction2() {
        int result = calculatorService.subtraction2(new Request(1, 1)).getSolution();
        assertThat(result).isZero();
    }
}