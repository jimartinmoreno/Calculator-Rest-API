package com.sanitas.calculator.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


public class Response {
    @Getter
    private final int solution;

    @JsonCreator
    public Response(@JsonProperty int solution) {
        this.solution = solution;
    }


}
