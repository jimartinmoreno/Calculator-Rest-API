package com.sanitas.calculator.service;

import com.sanitas.calculator.domain.Request;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int sum(Request request) {
        return request.getValue1() + request.getValue2();
    }

    @Override
    public int subtraction(Request request) {
        return request.getValue1() - request.getValue2();
    }
}
