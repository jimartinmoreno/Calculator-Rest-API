package com.sanitas.calculator.service;

import com.sanitas.calculator.domain.Request;
import com.sanitas.calculator.domain.Response;

public interface CalculatorService {
    int sum(Request request);
    int subtraction(Request request);

    Response sum2(Request request);
    Response subtraction2(Request request);
}
