package com.sanitas.calculator;

import com.sanitas.calculator.controller.CalculatorController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class CalculatorApplicationTests {

    @Autowired
    CalculatorController calculatorController;
    @Test
    void contextLoads() {
        assertThat(calculatorController).isNotNull();
    }

}
