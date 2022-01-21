package com.sanitas.calculator.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Request {
    @NotNull
    private final int value1;
    @NotNull
    private final int value2;
}
