package com.sanitas.calculator.service;

import com.sanitas.calculator.domain.Request;

public interface CalculatorService {
    int sum(Request request);
    int subtraction(Request request);
}
