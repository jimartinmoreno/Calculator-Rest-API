package com.sanitas.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.calculator.domain.Request;
import com.sanitas.calculator.domain.Response;
import com.sanitas.calculator.service.CalculatorService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CalculatorController calculatorController;

    @Autowired
    CalculatorService calculatorService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSum() {
        ResponseEntity<Response> result = calculatorController.sum(new Request(1, 1));
        assertThat(Objects.requireNonNull(result.getBody()).getSolution()).isEqualTo(2);
    }

    @Test
    void testSubtraction() {
        ResponseEntity<Response> result = calculatorController.subtraction(new Request(1, 1));
        assertThat(Objects.requireNonNull(result.getBody()).getSolution()).isZero();
    }

    @Test
    void testSumRest() {
        ResponseEntity<Response> response = this.restTemplate.postForEntity("http://localhost:" + port + "/api/v1/calc/sum", new Request(1, 1), Response.class);
        assertThat(Objects.requireNonNull(response.getBody()).getSolution()).isEqualTo(2);
    }

    @Test
    void testSubtractionRest() {

        ResponseEntity<Response> response = this.restTemplate.postForEntity("http://localhost:" + port + "/api/v1/calc/subtraction", new Request(1, 1), Response.class);
        assertThat(Objects.requireNonNull(response.getBody()).getSolution()).isZero();
    }

}
